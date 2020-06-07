//我们提供了一个类：
//
// 
//public class Foo {
//  public void one() { print("one"); }
//  public void two() { print("two"); }
//  public void three() { print("three"); }
//}
// 
//
// 三个不同的线程将会共用一个 Foo 实例。 
//
// 
// 线程 A 将会调用 one() 方法 
// 线程 B 将会调用 two() 方法 
// 线程 C 将会调用 three() 方法 
// 
//
// 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3]
//输出: "onetwothree"
//解释: 
//有三个线程会被异步启动。
//输入 [1,2,3] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 two() 方法，线程 C 将会调用 three() 方法。
//正确的输出是 "onetwothree"。
// 
//
// 示例 2: 
//
// 
//输入: [1,3,2]
//输出: "onetwothree"
//解释: 
//输入 [1,3,2] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 three() 方法，线程 C 将会调用 two() 方法。
//正确的输出是 "onetwothree"。 
//
// 
//
// 注意: 
//
// 尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。 
//
// 你看到的输入格式主要是为了确保测试的全面性。 
//


package leetcode.editor.cn;

import java.util.concurrent.Semaphore;

public class PrintInOrder {
    public static void main(String[] args) {
        Foo solution = new PrintInOrder().new Foo();
    }

    /**
     * 尝试使用 synchronized、semaphore、volatile三种方式实现
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Foo {

        Semaphore first = new Semaphore(0);
        Semaphore second = new Semaphore(0);

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            printFirst.run();
            first.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            first.acquire();
            printSecond.run();
            second.release();

        }

        public void third(Runnable printThird) throws InterruptedException {
            second.acquire();
            printThird.run();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class Foo1 {
        volatile boolean first = false;
        volatile boolean second = false;

        public Foo1() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            first = true;
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (!first) {
                Thread.currentThread().yield();
            }

            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            second = true;
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (!second) {
                Thread.currentThread().yield();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();

        }
    }

    class Foo2 {

        boolean first = false;
        boolean second = false;

        Object lock = new Object();

        public Foo2() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            synchronized (lock) {
                printFirst.run();
                first = true;
                lock.notifyAll();
            }

        }

        public void second(Runnable printSecond) throws InterruptedException {
            synchronized (lock) {
                while (first != true) {
                    lock.wait();
                }
                printSecond.run();
                second = true;
                lock.notifyAll();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            synchronized (lock) {
                while (second != true) {
                    lock.wait();
                }
                printThird.run();
            }
        }
    }

}

package impl.other;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TwoThreadTakeTurnPrint {

    public static void main(String[] args) {
        HelloWorld0 helloWorld = new HelloWorld0();

        Runnable r1 = () -> helloWorld.hello(10);
        Runnable r2 = () -> helloWorld.world(10);
        new Thread(r1).start();
        new Thread(r2).start();

    }


}

class HelloWorld1 {
    SynchronousQueue q = new SynchronousQueue();
    int flag = 0;
    public void hello(int n) {

        while (n > 0) {
            while (flag ==1){

            }
            System.out.print("hello");
            flag = 1;
            try {
                q.put(new Object());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            n--;
        }
    }


    public void world(int n) {
        while (n > 0) {
            while (flag ==0){

            }

            try {
                Object take = q.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("world");
            flag = 0;
            n--;
        }
    }
}

class HelloWorld0 {
    // 使用一个条件作为协作的条件。以flag作为工作阶段的标志位
    private static ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    int flag = 0;

    public void hello(int n) {
        while (n > 0) {

            try {
                lock.lock();
                while (flag == 1){
                    condition.await();
                }
                System.out.print("hello");
                flag = 1;
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                n--;
            }
        }
    }

    public void world(int n) {
        while (n > 0) {
            try {
                lock.lock();
                while (flag == 0){
                    condition.await();
                }
                System.out.println("world");
                flag = 0;
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                n--;
            }
        }
    }

}


class HelloWorld {


    static volatile CountDownLatch c1 = new CountDownLatch(1);
    static volatile CountDownLatch c2 = new CountDownLatch(1);

    public void hello(int n) {
        //
        // try{
        // lock.lock();
        // hello.await()
        // System.out.print("hello");
        // world.signal();
        // }finally{
        // lock.unlock();
        // }
        // }
        while (n > 0) {
            c1.countDown();
            System.out.print("hello");
            try {
                c2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            c2 = new CountDownLatch(1);
            n--;
        }
    }

    public void world(int n) {
//
//       try{
//         lock.lock();
//         world.await()
// 		System.out.println("world");
//         hello.signal();
//       }finally{
//       	lock.unlock();
//       }


        while (n > 0) {
            try {
                c1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("world");
            c2.countDown();
            c1 = new CountDownLatch(1);

            n--;
        }

    }

}
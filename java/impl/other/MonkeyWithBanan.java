package impl.other;

public class MonkeyWithBanan {
    //题目没有说交替拿，所以没有做等待唤醒
    public static volatile Integer total = 9;
    public static Object monitor = new Object();

    public static void main(String[] args) {
        Monkey m1 = new Monkey(3);
        Monkey m2 = new Monkey(2);
        new Thread(m1).start();
        new Thread(m2).start();

    }


    static class Monkey implements Runnable {

        public Monkey(Integer num) {
            this.num = num;
        }

        private Integer num;

        public void run() {
            while (total >= num) {
                synchronized (MonkeyWithBanan.class) {
                    if(total >= num){
                        total = total - num;
                        System.out.println("拿到" + num+",剩余"+total);
                    }
                }
            }
        }
    }
}

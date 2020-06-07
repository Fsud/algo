package impl.other;

public class HelloW {
    public static void main(String args[]) {
        HelloW t = new HelloW();
        int n = 10;
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (t) {
                    for (int i = 0; i < n; ) {
                        t.hello(i);
                        try {
                            t.notify();
                            i++;
                            if(i>=n){break;}
                            t.wait();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (t) {
                    for (int i = 0; i < n;) {
                        t.world(i);
                        try {
                            t.notify();

                            i++;
                            if(i>=n){break;}
                            t.wait();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        a.start();
        b.start();
    }

    public void hello(int n) {

        System.out.print("hello");

    }

    public void world(int n) {
        System.out.println("world");

    }
}

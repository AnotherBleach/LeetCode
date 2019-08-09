package LockTest;

public class ThreadTest {
    private static int x = 0;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            synchronized (ThreadTest.class) {

                for (int j = 0; j < 200; j++) {
                    if (x != 0) {
                        try {
                            ThreadTest.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    x = x + 1;
                    System.out.println("加线程1得到锁  "+x);
                    ThreadTest.class.notify();

                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (ThreadTest.class) {
                for (int i = 0; i < 200; i++) {
                    if (x == 0) {
                        try {
                            ThreadTest.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if(x!=0)
                    x = x - 1;
                    System.out.println("减线程1得到锁  "+x);
                    ThreadTest.class.notify();

                }
            }
        });

        t1.start();
        t2.start();


        Thread t3 = new Thread(() -> {
            synchronized (ThreadTest.class) {
                for (int i = 0; i < 200; i++) {
                    if (x == 0) {
                        try {
                            ThreadTest.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                       // Class.forName("");
                    }
                    if(x!=0)
                    x = x - 1;
                  //  System.out.println(x);
                    System.out.println("减线程2得到锁  "+x);
                    ThreadTest.class.notify();

                }
            }
        });
    //    t3.start();


    }


}

package Bonus;

import java.util.concurrent.TimeUnit;

class aThread {

    public synchronized void show()
    {

        System.out.println("aaa start");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("aaa stop");
    }

    public  void show2()
    {

        System.out.println("bbb start");

        System.out.println("bbb stop");
    }
}
public class ThreadTest {
    public static void main(String[] args) {
        aThread aThread = new aThread();
        new Thread(()->{
            aThread.show();

        }).start();
        new Thread(()->{
            aThread.show2();

        }).start();

    }
}

package Lock.CountDownLatchTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class one extends Thread{

    CountDownLatch latch;
    public one(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("one");
        latch.countDown();
    }
}
class two extends Thread{


    CountDownLatch latch;
    public two(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("two");
        latch.countDown();
    }

}
class three extends Thread{

    CountDownLatch latch;
    public three(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("three");

    }

}
public class Main {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(2);
        one a = new one(latch);
        two b = new two(latch);
        three  c = new three(latch);
        c.start();
        TimeUnit.SECONDS.sleep(2
        );
        a.start();
        b.start();

    }
}

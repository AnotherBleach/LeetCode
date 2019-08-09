package Lock.Join;

import java.util.concurrent.TimeUnit;

public class MainTest {
    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        B b = new B(a);
        b.start();
        TimeUnit.SECONDS.sleep(3);
        a.start();


    }
}

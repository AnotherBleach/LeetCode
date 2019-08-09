package Lock.Join;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class A extends Thread {

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("A");
    }

}

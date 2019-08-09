package 通配符;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class MyCallable implements Callable<Integer> {
    public Integer call() {
        return 123;
    }
}
class myt extends Thread implements Runnable{


    @Override
    public void run() {
        while(true){

            if(interrupted()){
                System.out.println("Bye");
                return ;
            }
            System.out.println(interrupted());
            try {
                TimeUnit.SECONDS.sleep(1);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
public class CallableTest {

    class a{


    }
    static class b{


    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Thread t = new Thread(new myt());
        t.start();
        Thread.sleep(2);
        t.interrupt();
        System.out.println(t.isInterrupted());

     //   a aa = new a();
       // b bb = new b();

//        MyCallable mc = new MyCallable();
//        FutureTask<Integer> ft = new FutureTask<>(mc);
//        Thread thread = new Thread(ft);
//        thread.start();
//        System.out.println(ft.get());

    }
}

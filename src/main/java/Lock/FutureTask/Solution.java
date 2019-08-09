package Lock.FutureTask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

class data {

    private volatile int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void addNum(int num) {
        this.num += num;
    }
}

public class Solution {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        data me = new data();
//
//        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                me.addNum(2);
//                return me.getNum();
//            }
//        });
//        new Thread(task).start();
//        System.out.println(task.get());
//        //AtomicInteger
        // ThreadLocal;
        myThread t = new myThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
            t.setName("23333");
            t.start();
            t.show();

    }
}

class myThread extends Thread {
    public myThread(Runnable runnable) {
        super(runnable);
    }

    public void show()
    {
     //   ThreadLocal
        System.out.println("线程外部 "+Thread.currentThread().getName());

    }

}

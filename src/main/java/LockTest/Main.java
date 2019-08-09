package LockTest;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    static  int x=0;
    ReentrantLock reentrantLock;
    static MyLock lock = new MyLock();
    public static void main(String[] args) throws InterruptedException {

       Thread t1= new Thread(()->{for(int i=0;i<10000;i++){
            lock.lock();
            alter();
            lock.unlock();
        }});
       Thread t2=new Thread(()->{for(int i=0;i<10000;i++){

           lock.lock();
           alter();
           lock.unlock();
        }});

        t2.start();
        t1.start();
        t1.join();
        t2.join();
        System.out.println("x = "+x);
    }
    static void alter()
    {
        x++;
    }
}

package Lock.ReentrantLockTest;

import java.util.concurrent.locks.ReentrantLock;

public  class BufferInterruptibly {

    private ReentrantLock lock = new ReentrantLock();

    public void write(Thread worker) {
        lock.lock();
        try {
            long startTime = System.currentTimeMillis();
            System.out.println("开始往这个buff写入数据…");
            for (;;)// 模拟要处理很长时间
            {
                if (System.currentTimeMillis()
                        - startTime > Integer.MAX_VALUE)
                    break;
                if(worker.isInterrupted()){
                    System.out.println("写被打断了，Bye");
                    return;
                }

            }
            System.out.println("终于写完了");
        } finally {
            lock.unlock();
        }
    }
    public void read() throws InterruptedException {
        lock.lockInterruptibly();//注意这里，可以响应中断，抛出中断异常。
        //lock.lock();
        try {
            System.out.println("从这个buff读数据");
        } finally {
            lock.unlock();
        }
    }
}

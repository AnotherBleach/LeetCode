package Lock.ReentrantLockTest;

public class Writer extends Thread{

    private BufferInterruptibly buff;

    public Writer(BufferInterruptibly buff) {
        this.buff = buff;
    }

    @Override
    public void run() {

        buff.write(this);
        System.out.println("写结束");
    }
}

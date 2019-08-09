//package Lock.ReentrantLockTest;
//
//public class MainTest {
//    public static void main(String[] args) throws InterruptedException {
//        BufferInterruptibly buff = new BufferInterruptibly();
//        final Writer writer = new Writer(buff);
//        final Reader reader = new Reader(buff);
//
//        writer.start();
//        Thread.sleep(1000);
//        reader.start();
//
//        new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                long start = System.currentTimeMillis();
//                for (; ; ) {
//                    if (System.currentTimeMillis()
//                            - start > 10000) {
//                        System.out.println("不等了，尝试中断");
//                        writer.interrupt();
//                        break;
//                    }
//
//                }
//
//            }
//        }).start();
//    }
//}

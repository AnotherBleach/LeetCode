//package 通配符;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.TimeUnit;
//
//class Task{
//
//    public synchronized void test() throws InterruptedException {
//        System.out.println("test...");
//        TimeUnit.SECONDS.sleep(5);
//
//    }
//    public  synchronized  static void happy() throws InterruptedException {
//        System.out.println("happy...");
//        TimeUnit.SECONDS.sleep(5);
//
//
//    }
//
//}
//public class ThreadTest {
//    public static void main(String[] args) {
//        Task task = new Task();
//        Task task1 = new Task();
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(()->{
//            try {
//                task.happy();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        executorService.execute(()->{
//            try {
//                task1.happy();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        executorService.shutdown();
//
//
//    }
//}

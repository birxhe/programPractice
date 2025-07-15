package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    private static Semaphore s1 = new Semaphore(1);
    private static Semaphore s2 = new Semaphore(1);
    private static Semaphore s3 = new Semaphore(1);
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        try {
            s2.acquire();
            s3.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPool.submit(() -> {
            try {
                s1.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程1执行任务");
            s2.release();
        });
        threadPool.submit(() -> {
            try {
                s2.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程2执行任务");
            s3.release();
        });
        threadPool.submit(() -> {
            try {
                s3.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程3执行任务");
            s1.release();
        });

//        new Thread(() -> {
//            try {
//                s1.acquire();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("线程1执行任务");
//            s2.release();
//        }).start();

//        new Thread(() -> {
//            try {
//                s1.acquire();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("线程2执行任务");
//            s2.release();
//        }).start();

//        new Thread(() -> {
//            try {
//                s1.acquire();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("线程3执行任务");
//            s2.release();
//        }).start();
    }
}

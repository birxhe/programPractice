package Lock;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockDemo {
    public static void main(String[] args) {
        // 创建公平锁
        ReentrantLock lock = new ReentrantLock(true);
        // 创建线程池（三个核心线程）
        ExecutorService pool = Executors.newFixedThreadPool(3);
        // 创建线程任务
        Runnable task = () -> {
            // 线程循环竞争锁
            while (true) {
                if (lock.tryLock()) {
                    try {
                        System.out.println("线程【" + Thread.currentThread().getName() + "】获得锁");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } finally {
                        // 释放锁
                        lock.unlock();
                    }
                }
            }
        };
        // 提交任务
        for (int i=0; i < 3; i++) {
            pool.submit(task);
        }
        // 关闭线程池
        pool.shutdown();
    }
}

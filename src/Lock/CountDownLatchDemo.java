package Lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(1);
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            threadPool.submit(() -> {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("当前线程：" + Thread.currentThread().getName() +"执行，时间：" + System.currentTimeMillis());
            });
        }
        latch.countDown();
    }
}

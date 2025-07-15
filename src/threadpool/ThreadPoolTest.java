package threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(10, 20, 1,
                        TimeUnit.MINUTES, new LinkedBlockingQueue<>(50), Executors.defaultThreadFactory(),
                        new CustomRejectedHandler());
        for (int i = 0; i < 1000; i++) {
            final int taskId = i;
            threadPoolExecutor.execute(() -> {
                System.out.println("当前任务id = " + taskId);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        threadPoolExecutor.shutdown();
    }
}

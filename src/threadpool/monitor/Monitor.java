package threadpool.monitor;

import threadpool.CustomRejectedHandler;

import java.util.concurrent.*;

public class Monitor {
    public static void main(String[] args) {
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(10, 20, 1,
                        TimeUnit.MINUTES, new LinkedBlockingQueue<>(50), Executors.defaultThreadFactory(),
                        new CustomRejectedHandler());

        // 定时打印状态（示例）
        ScheduledThreadPoolExecutor monitor = new ScheduledThreadPoolExecutor(1);
        monitor.scheduleAtFixedRate(() -> {
            System.out.println("=== 线程池状态 ===");
            System.out.println("活跃线程: " + executor.getActiveCount());
            System.out.println("队列积压: " + executor.getQueue().size());
            System.out.println("完成任务: " + executor.getCompletedTaskCount());
            System.out.println("总任务: " + executor.getTaskCount());
        }, 5, 5, TimeUnit.SECONDS);  // 每5秒采集一次
    }
}

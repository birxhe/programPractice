package threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RejectedPolicyDemo {
    public static void main(String[] args) {
        // 创建任务
        Runnable task1 = () -> System.out.println(Thread.currentThread().getName() + "执行任务1");
        Runnable task2 = () -> System.out.println(Thread.currentThread().getName() + "执行任务2");
        Runnable task3 = () -> System.out.println(Thread.currentThread().getName() + "执行任务3");
        // 创建线程池
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1),
//                new ThreadPoolExecutor.AbortPolicy()// 中断任务，抛出异常
//                new ThreadPoolExecutor.DiscardPolicy()// 丢弃任务，不处理任务
//                new ThreadPoolExecutor.DiscardOldestPolicy()// 丢弃队列中最老的任务，执行最新的任务
//                new ThreadPoolExecutor.CallerRunsPolicy()// 不处理任务，交给调用方处理任务
                new CustomRejectedHandler()// 自定义拒绝策略
        );
        // 提交任务
        pool.submit(task1);
        pool.submit(task2);
        pool.submit(task3);
        //关闭线程池
        pool.shutdown();
    }
}

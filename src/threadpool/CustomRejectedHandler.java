package threadpool;

import java.util.concurrent.*;

/**
 * 自定义拒绝策略
 */
public class CustomRejectedHandler implements RejectedExecutionHandler{
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        // 判断线程未关闭
        if (!executor.isShutdown()) {
            // 获取阻塞队列
            BlockingQueue<Runnable> queue = executor.getQueue();
            // 将旧任务移除
            queue.poll();
            // 添加新任务
            queue.add(r);
        }
    }
}

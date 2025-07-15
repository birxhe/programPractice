package Lock;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3);
        Runnable task = () -> {
            try {
                Thread.sleep(1000);
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + "开始执行任务，time：" + System.currentTimeMillis());
        };
        for (int i = 0; i < 3; i++) {
            new Thread(task).start();
        }
    }
}

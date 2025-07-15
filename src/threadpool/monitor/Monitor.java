package threadpool.monitor;

import threadpool.CustomRejectedHandler;

import java.util.concurrent.*;

public class Monitor {
    public static void main(String[] args) {
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(10, 20, 1,
                        TimeUnit.MINUTES, new LinkedBlockingQueue<>(50), Executors.defaultThreadFactory(),
                        new CustomRejectedHandler());

        // ��ʱ��ӡ״̬��ʾ����
        ScheduledThreadPoolExecutor monitor = new ScheduledThreadPoolExecutor(1);
        monitor.scheduleAtFixedRate(() -> {
            System.out.println("=== �̳߳�״̬ ===");
            System.out.println("��Ծ�߳�: " + executor.getActiveCount());
            System.out.println("���л�ѹ: " + executor.getQueue().size());
            System.out.println("�������: " + executor.getCompletedTaskCount());
            System.out.println("������: " + executor.getTaskCount());
        }, 5, 5, TimeUnit.SECONDS);  // ÿ5��ɼ�һ��
    }
}

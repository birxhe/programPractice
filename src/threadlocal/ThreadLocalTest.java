package threadlocal;

import java.text.SimpleDateFormat;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLocalTest {
    private static final ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    private static final ThreadLocal<SimpleDateFormat> dateFormat =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));
    ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set(1);
                System.out.println("�߳�1����ֵΪ1");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("�߳�1ȡֵ��" + threadLocal.get());
                threadLocal.remove();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("�߳�2ȡֵ��" + threadLocal.get());
            }
        }).start();
    }
}

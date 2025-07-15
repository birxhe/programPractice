package threadlocal;

public class ThreadLocalTest2 {
    private static ThreadLocal<String> threadLocal = new ThreadLocal();
    public static void main(String[] args) {
        threadLocal.set("test");
        String context = threadLocal.get();
        new Thread(() -> {
            threadLocal.set(context);
            System.out.println("���߳�ȡֵ" + threadLocal.get());
            threadLocal.remove();
        }).start();
        System.out.println("���߳�ȡֵ" + threadLocal.get());
    }
}

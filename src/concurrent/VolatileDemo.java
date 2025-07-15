package concurrent;

public class VolatileDemo {
    public static volatile int ticket = 1;
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                if (ticket == 1) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程1执行任务");
                    ticket = 2;
                    return;
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (true) {
                if (ticket == 2) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程2执行任务");
                    ticket = 3;
                    return;
                }
            }
        });
        Thread t3 = new Thread(() -> {
            while (true) {
                if (ticket == 3) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程3执行任务");
                    ticket = 1;
                    return;
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}

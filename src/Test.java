import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Test {
    public static void main(String[] args) {
        // 1、统计一个字符串中出现次数最多的字母个数
//        String str = "abbcccdddd1111122223333333";
//        Set set = calculateMaxOfLetter(str);
//        System.out.println(set);
        // 2、线程t1 for循环打印1，线程t2 for循环打印2，线程t3 for循环打印3，如何控制循环打印1 2 3 1 2 3。。。
        Data3 data3 = new Data3();
        new Thread(() -> {
            for (int i=0; i<10; i++) {
                data3.print1();
            }
        }, "1").start();
        new Thread(() -> {
            for (int i=0; i<10; i++) {
                data3.print2();
            }
        }, "2").start();
        new Thread(() -> {
            for (int i=0; i<10; i++) {
                data3.print3();
            }
        }, "3").start();
        //3、父类的静态方法是否会被子类继承
//        Father father = new Father();
//        Father son = new Son();
//
//        son.a();
//        Father.a();
//        Son.a();
        //4、map
//        Map<String, String> map = new HashMap<>();
//        map.put("name", "Kobe");
//        String ret = map.put("name", "Lebron");
//        String value = map.get("name");
//        System.out.println(ret);
//        System.out.println(value);
        
    }

    private static Set calculateMaxOfLetter(String str) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (Character ch : str.toCharArray()) {
            if ((ch>='a'&&ch<='z') || (ch>='A'&&ch<='Z')) {
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                } else {
                    map.put(ch, 1);
                }
            }
        }
        Integer maxNum = Collections.max(map.values());
        Set<Character> set = new HashSet<>();
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxNum) {
                set.add(entry.getKey());
            }
        }
        return set;
    }
}

class Data3 {
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    int number = 1;

    public void print1() {
        lock.lock();
            try {
                while (number != 1) {
                    condition1.await();
                }
                System.out.println(Thread.currentThread().getName() + "---->1");
                number = 2;
                condition2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    public void print2() {
        lock.lock();
        try {
            while (number != 2) {
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName() + "---->2");
            number = 3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void print3() {
        lock.lock();
        try {
            while (number != 3) {
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName() + "---->3");
            number = 1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void method1() {

    }

    public static synchronized void method2() {

    }

    public void method3() {
        synchronized (this) {

        }
    }
}

class Father {
    public static int a = 1;
    public static void a() {
        System.out.println("Father");
    }
}

class Son extends Father{
    public static int a = 2;
    public static void a() {
        System.out.println("Son");
    }
}

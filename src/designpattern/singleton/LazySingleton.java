package designpattern.singleton;

// 懒汉式
public class LazySingleton {
    // 私有化成员变量
    private volatile static LazySingleton singleton = null;

    // 私有化构造方法
    private LazySingleton() {}

    // 提供公共方法获取单例实例
    public LazySingleton getSingleton() {
        // 双重检查锁(Double check lock)
        if (singleton == null) {
            synchronized (singleton) {
                if (singleton == null) {
                    singleton = new LazySingleton();
                }
            }
        }
        return singleton;
    }
}

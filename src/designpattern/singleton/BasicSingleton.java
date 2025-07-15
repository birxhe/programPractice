package designpattern.singleton;

// 俄汉式
public class BasicSingleton {
    // 私有化成员变量
    private static BasicSingleton singleton = new BasicSingleton();

    // 私有化构造方法
    private BasicSingleton() {}

    // 提供公共方法获取单例实例
    public BasicSingleton getSingleton() {
        return singleton;
    }
}

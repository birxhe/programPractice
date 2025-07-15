package designpattern.singleton;

// ����ʽ
public class LazySingleton {
    // ˽�л���Ա����
    private volatile static LazySingleton singleton = null;

    // ˽�л����췽��
    private LazySingleton() {}

    // �ṩ����������ȡ����ʵ��
    public LazySingleton getSingleton() {
        // ˫�ؼ����(Double check lock)
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

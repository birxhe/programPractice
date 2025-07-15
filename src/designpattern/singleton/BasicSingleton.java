package designpattern.singleton;

// ��ʽ
public class BasicSingleton {
    // ˽�л���Ա����
    private static BasicSingleton singleton = new BasicSingleton();

    // ˽�л����췽��
    private BasicSingleton() {}

    // �ṩ����������ȡ����ʵ��
    public BasicSingleton getSingleton() {
        return singleton;
    }
}

package designpattern.observer;

/**
 * ��
 * ������󣬸�����ӹ۲��ߣ�֪ͨ�۲���
 */
public interface Debit {
    /**
     * ��Ǯ
     */
    void borrow(Credit credit);

    /**
     * ֪ͨ��Ǯ
     */
    void notifyRepay();
}

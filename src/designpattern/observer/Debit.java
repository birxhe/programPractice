package designpattern.observer;

/**
 * 借款方
 * 主题对象，负责添加观察者，通知观察者
 */
public interface Debit {
    /**
     * 借钱
     */
    void borrow(Credit credit);

    /**
     * 通知还钱
     */
    void notifyRepay();
}

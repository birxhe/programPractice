package designpattern.observer;

/**
 * 贷款方
 * 观察者，负责检查主题对象，然后执行相关操作
 */
public interface Credit {
    /**
     * 询问还钱
     */
    void takeMoney();
}

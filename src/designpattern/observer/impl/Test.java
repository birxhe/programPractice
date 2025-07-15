package designpattern.observer.impl;

import designpattern.observer.Debit;

public class Test {
    public static void main(String[] args) {
        Debit zhangSan = new ZhangSanDebit();
        zhangSan.borrow(new LiSiCredit());
        zhangSan.borrow(new WangWuCredit());
        zhangSan.notifyRepay();
    }
}

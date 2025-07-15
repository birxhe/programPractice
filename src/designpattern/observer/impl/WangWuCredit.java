package designpattern.observer.impl;

import designpattern.observer.Credit;

public class WangWuCredit implements Credit {
    @Override
    public void takeMoney() {
        System.out.println("Wangwu takeMoney.");
    }
}

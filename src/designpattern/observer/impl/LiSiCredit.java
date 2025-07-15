package designpattern.observer.impl;

import designpattern.observer.Credit;

public class LiSiCredit implements Credit {

    @Override
    public void takeMoney() {
        System.out.println("Lisi takeMoney.");
    }
}

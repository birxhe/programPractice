package designpattern.observer.impl;

import designpattern.observer.Credit;
import designpattern.observer.Debit;

import java.util.ArrayList;
import java.util.List;

public class ZhangSanDebit implements Debit {
    List<Credit> credits = new ArrayList<>();
    @Override
    public void borrow(Credit credit) {
        credits.add(credit);
    }

    @Override
    public void notifyRepay() {
        credits.forEach(credit -> credit.takeMoney());
    }
}

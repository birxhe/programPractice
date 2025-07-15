package designpattern.strategy.impl;

import designpattern.strategy.Strategy;

public class AddStrategy implements Strategy {
    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}

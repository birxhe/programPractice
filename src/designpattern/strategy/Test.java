package designpattern.strategy;

import designpattern.strategy.impl.AddStrategy;
import designpattern.strategy.impl.SubstractStrategy;

public class Test {
    public static void main(String[] args) {
        Environment environment = new Environment(new SubstractStrategy());
        int result = environment.calculate(1, 2);
        System.out.println(result);
    }
}

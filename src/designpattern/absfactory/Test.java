package designpattern.absfactory;

import designpattern.absfactory.abs.AbstractFoodFactory;

public class Test {
    public static void main(String[] args) {
        AbstractFoodFactory lzFoodFactory = new LzFoodFactory();
        AbstractFoodFactory szFoodFactory = new SzFoodFactory();
        lzFoodFactory.createDrink();
        lzFoodFactory.createNoodle();
        szFoodFactory.createDrink();
        szFoodFactory.createNoodle();
    }
}

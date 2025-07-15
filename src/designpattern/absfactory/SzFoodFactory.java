package designpattern.absfactory;

import designpattern.absfactory.abs.AbstractFoodFactory;

public class SzFoodFactory extends AbstractFoodFactory {
    @Override
    public void createDrink() {
        new Color().price();
    }

    @Override
    public void createNoodle() {
        new SzNoodle().desc();
    }
}


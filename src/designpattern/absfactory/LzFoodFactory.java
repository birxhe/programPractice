package designpattern.absfactory;

import designpattern.absfactory.abs.AbstractFoodFactory;

public class LzFoodFactory extends AbstractFoodFactory {
    @Override
    public void createDrink() {
        new Water().price();
    }

    @Override
    public void createNoodle() {
        new LzNoodle().desc();
    }
}

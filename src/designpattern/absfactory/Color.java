package designpattern.absfactory;

import designpattern.absfactory.abs.Drink;

public class Color extends Drink {
    @Override
    public void price() {
        System.out.println("Color 3 yuan.");
    }
}

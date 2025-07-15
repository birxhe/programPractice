package designpattern.absfactory;

import designpattern.absfactory.abs.Drink;

public class Water extends Drink {
    public void price() {
        System.out.println("Water 1 yuan");
    }
}

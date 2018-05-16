package com.fanchen.clearmind.design.duck.implementations;

import com.fanchen.clearmind.design.duck.interfaces.FlyBehavior;

public class FlyDown implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Dropping, down, down ...");
    }
}

package com.fanchen.clearmind.design.duck.implementations;

import com.fanchen.clearmind.design.duck.interfaces.FlyBehavior;

public class FlyFlap implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Flap, flap, flap ...");
    }
}

package com.fanchen.clearmind.design.duck.implementations;

import com.fanchen.clearmind.design.duck.interfaces.FlyBehavior;

public class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println("I can’t fly");
    }
}
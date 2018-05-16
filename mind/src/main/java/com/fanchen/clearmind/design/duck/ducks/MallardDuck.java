package com.fanchen.clearmind.design.duck.ducks;

import com.fanchen.clearmind.design.duck.implementations.FlyDown;
import com.fanchen.clearmind.design.duck.implementations.MuteQuack;

public class MallardDuck extends Duck{
    public MallardDuck() {
        quackBehavior = new MuteQuack();
        flyBehavior = new FlyDown();
    }

    public void display() {
        System.out.println("I’m a real Mallard duck ");
    }
}

package com.fanchen.clearmind.design.duck.ducks;


import com.fanchen.clearmind.design.duck.implementations.FlyNoWay;
import com.fanchen.clearmind.design.duck.implementations.MuteQuack;

public class ModelDuck extends Duck {

    @Override
    public void display() {
        System.out.println("This is a model duck");
    }
    public ModelDuck() {
        quackBehavior = new MuteQuack();
        flyBehavior = new FlyNoWay();
    }
}

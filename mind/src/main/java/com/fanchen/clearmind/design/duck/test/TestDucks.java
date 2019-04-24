package com.fanchen.clearmind.design.duck.test;

import com.fanchen.clearmind.design.duck.ducks.Duck;
import com.fanchen.clearmind.design.duck.ducks.MallardDuck;
import com.fanchen.clearmind.design.duck.ducks.ModelDuck;
import com.fanchen.clearmind.design.duck.implementations.FlyFlap;

public class TestDucks {
    public static void main(String[] args) {
        Duck d = new MallardDuck();
        d.performFly();
        d.performQuack();

        Duck model = new ModelDuck();
//        model.performFly();
        model.setFlyBehavior(new FlyFlap());
        model.performFly();

    }
}

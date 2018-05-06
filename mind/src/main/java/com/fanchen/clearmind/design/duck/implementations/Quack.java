package com.fanchen.clearmind.design.duck.implementations;

import com.fanchen.clearmind.design.duck.interfaces.QuackBehavior;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack, quack, quack ...");
    }
}

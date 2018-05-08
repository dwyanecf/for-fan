package com.fanchen.clearmind.design.duck.implementations;

import com.fanchen.clearmind.design.duck.interfaces.QuackBehavior;

public class MuteQuack implements QuackBehavior {
    public void quack() {
        System.out.println("<< Silence >>");
    }
}

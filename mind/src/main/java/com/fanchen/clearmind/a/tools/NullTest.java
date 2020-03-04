package com.fanchen.clearmind.a.tools;

import java.util.HashMap;
import java.util.Map;

public class NullTest {

    private String  name;
    private int age;
    private Map<Integer,String> map;

    public NullTest(){

    }



    public static void main(String[] args){
        MapExample example = new MapExample();
        example.map = new HashMap<>();

        NullTest test = new NullTest();
        test.name = example.map.get(1);
        System.out.println(test.name);


    }



}

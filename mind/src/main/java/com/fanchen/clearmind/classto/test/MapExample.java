package com.fanchen.clearmind.classto.test;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;


public class MapExample{

    public String  name;
    public int age;
    public Map<Integer,String> map;

    public MapExample(){

    }


    protected static final SimpleDateFormat mdy = new SimpleDateFormat("MM-dd-yyyy");

    private static final ThreadLocal<SimpleDateFormat> mdyFormatter = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return mdy;
        }
    };

    protected static final SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");

    private static final ThreadLocal<SimpleDateFormat> ymdFormatter = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return ymd;
        }
    };


    public static void main(String[] args) throws ParseException {
        String saleCfmdDt = "2018-05-10 06:44:32";
        saleCfmdDt = StringUtils.isBlank(saleCfmdDt) ? "": mdyFormatter.get().format(ymdFormatter.get().parse(saleCfmdDt));
        System.out.println(saleCfmdDt);

    }





}
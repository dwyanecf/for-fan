package com.fanchen.clearmind.classto.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;


public class MapExample {

    protected static final SimpleDateFormat mdy = new SimpleDateFormat("MM-dd-yyyy");
    protected static final SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
    private static final ThreadLocal<SimpleDateFormat> mdyFormatter = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return mdy;
        }
    };
    private static final ThreadLocal<SimpleDateFormat> ymdFormatter = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return ymd;
        }
    };
    public String name;
    public int age;
    public Map<Integer, String> map;

    public MapExample() {

    }

    public static void main(String[] args) throws ParseException {
        String date = "2018-02-19T23:57:44.000Z";
        Date date1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX").parse(date);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");

        sdf.setTimeZone(TimeZone.getTimeZone("Africa/Sao_Tome"));

        System.out.println("UTC Time: " + sdf.format(date1));

        sdf.setTimeZone(TimeZone.getTimeZone("America/El_Salvador"));

        System.out.println("CET Time: " +sdf.format(date1));

//        String saleCfmdDt = StringUtils.isBlank(date) ? "" : mdyFormatter.get().format(ymdFormatter.get().parse(date));
//
//
//        System.out.println(date1);


    }


}
package com.fanchen.clearmind.classto.test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	 BigDecimal checkAmount = new BigDecimal("22.33");
    	 System.out.println(checkAmount.scale());
    	 
    	 
    	 
    	 Map<String, String> eventInfo = new HashMap<>();
    	 String[] tripKeys = new String[] {"1","2"};
    }
}

package com.fanchen.clearmind.classto.test;

import java.math.BigDecimal;

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
    }
}

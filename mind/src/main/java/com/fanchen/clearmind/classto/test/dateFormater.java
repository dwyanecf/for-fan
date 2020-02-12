/*
 * Copyright (C) 2020 Copart, Inc. All rights reserved.
 */
package com.fanchen.clearmind.classto.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Fan Chen
 *
 */
public class dateFormater {

	
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat DateFor = new SimpleDateFormat("ddMMYYYY");
		String stringDate = DateFor.format(date);
		System.out.println("Date Format with MM/dd/yyyy : "+stringDate);
	}
}

package com.fanchen.clearmind.classto.test;

import java.util.Calendar;
import java.util.TimeZone;

public class TimeZoneTest {
	public static void main(String[] args) {

		Calendar c = Calendar.getInstance();

		// get current TimeZone using
		TimeZone tz = c.getTimeZone();

		System.out.println("Current TimeZone is : " + tz.getDisplayName());

		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1; // Note: zero based!
		int date = c.get(Calendar.DAY_OF_MONTH);

	}

}

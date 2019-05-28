package com.fanchen.clearmind.classto.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateFormatUtils;

public class DateFormarter {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

	public static String format(String date, String pattern, String timeZone) throws ParseException {
		TimeZone tz = TimeZone.getTimeZone(timeZone);
		Date date1 = sdf.parse(date);
		return DateFormatUtils.format(date1, pattern, tz);
	}

	public static void main(String[] args) throws ParseException {
		System.out.println(format("2019-05-14T20:15:00.000Z", "dd.MM.yyyy", "CET"));
		
		//2019-05-13
		
	}
}

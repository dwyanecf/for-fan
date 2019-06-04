package com.fanchen.clearmind.classto.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateFormatUtils;

public class DateFormarter {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

	public static String format(String date, String pattern) throws ParseException {
		TimeZone tz = TimeZone.getDefault();
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date date1 = sdf.parse(date);
		return DateFormatUtils.format(date1, pattern, tz);
	}

	public static void main(String[] args) throws ParseException {
		System.out.println(format("2019-06-03T23:45:00.000Z", "dd.MM.yyyy"));
		System.out.println(format("2019-06-03T20:45:00.000Z", "dd.MM.yyyy"));
	}
}

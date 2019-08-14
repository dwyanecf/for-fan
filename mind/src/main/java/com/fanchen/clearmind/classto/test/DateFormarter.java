package com.fanchen.clearmind.classto.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateFormatUtils;

public class DateFormarter {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

	public static String format1(String date, String pattern) throws ParseException {
		TimeZone tz = TimeZone.getTimeZone("EST");
		System.out.println(tz.getDisplayName());
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date date1 = sdf.parse(date);
		System.out.println("Local time: "+ date1);
		System.out.println(DateFormatUtils.format(date1, pattern, tz));
		return "";
	}

	public static void main(String[] args) throws ParseException {
//"dd.MM.yyyy"
		System.out.println(format1("2019-06-25T04:26:22.000Z", "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
		System.out.println("~~~~~~~~~~~~~~~~~");
		System.out.println(format("2019-06-25T06:27:41.000Z", "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
	}

	public static String format(String date, String pattern) throws ParseException {
		DateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date thisDate = utcFormat.parse(date);
		System.out.println("Local time: "+ thisDate);
		DateFormat pstFormat = new SimpleDateFormat(pattern);
		pstFormat.setTimeZone(TimeZone.getTimeZone("CET"));
		System.out.println(pstFormat.format(thisDate));

		return "";
	}

}

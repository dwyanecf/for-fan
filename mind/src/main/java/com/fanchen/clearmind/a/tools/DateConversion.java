package com.fanchen.clearmind.a.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConversion {

	private static String dateFormatter = "yyyy-MM-dd'T'HH:mm:ss.SSSX";

	public static void main(String[] args) {
		
		
	}

	public String getDate(String str) throws ParseException {
		SimpleDateFormat parser = new SimpleDateFormat(dateFormatter);
		Date date = parser.parse(str);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = formatter.format(date);
		return formattedDate;
	}

}

/*
 * Copyright (C) 2019 Copart, Inc. All rights reserved.
 */
package com.fanchen.clearmind.a.tools;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.StringEscapeUtils;

/**
 * @author Fan Chen
 *
 */
public class Escape {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String text = "KELLY\\u001AS TRADINGS                  ";
		text = StringEscapeUtils.unescapeJava(text);
		System.out.println("text: " + text);

		String str1 = "\\u001a";
		byte[] arr = str1.getBytes("UTF-8");
		System.out.println("\\u001a");
		for (byte a : arr) {
			System.out.print(a);
		}
	}
}

/*
 * Copyright (C) 2019 Copart, Inc. All rights reserved.
 */
package com.fanchen.clearmind.classto.test;

import org.apache.commons.lang3.StringEscapeUtils;

/**
 * @author fachen
 *
 */
public class Escape {

	public static void main(String[] args) {
		String text = "IZZY O\\u001aKEEFE                  ";
		text = StringEscapeUtils.unescapeJava(text);
		System.out.println("text: " + text);
	}
}

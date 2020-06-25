/*
 * Copyright (C) 2020 Copart, Inc. All rights reserved.
 */
package com.fanchen.clearmind.classto.test;

import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 * @author fachen
 *
 */
public class timestamp {

	protected static final SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
	
	public static void main(String[] args) {
	
		
		System.out.println(String.valueOf(System.currentTimeMillis()));
	}
}

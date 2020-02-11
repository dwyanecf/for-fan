/*
 * Copyright (C) 2019 Copart, Inc. All rights reserved.
 */
package com.fanchen.clearmind.concept;

/**
 * @author Fan Chen
 *
 */
public class BooleanTest {

	public static void main(String[] args) {
		boolean b1 = Boolean.parseBoolean(null);
		boolean b2 = Boolean.parseBoolean("false");
		boolean b3 = Boolean.parseBoolean("true");

		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);

	}
}

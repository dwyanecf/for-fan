/*
 * Copyright (C) 2019 Copart, Inc. All rights reserved.
 */
package com.fanchen.clearmind.leetcode.string;

/**
 * @author Fan Chen
 *
 */
public class StringToInteger {

	public static int myAtoi(String str) {
		if (str.length() < 1)
			return 0;
		int sign = 1, res = 0, i = 0;
		while (str.charAt(i) == ' ')
			i++;
		if (str.charAt(i) == '-' || str.charAt(i) == '+') {
			sign = str.charAt(i++) == '-' ? -1 : 1;
		}
		while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7) {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			res = res * 10 + (str.charAt(i++) - '0');
		}
		return res * sign;
	}

	public static void main(String[] args) {
		int i = myAtoi("words and 987");
	}
}

package com.fanchen.clearmind.zillow.dianmian;

import java.util.Random;

public class RandomChar {

	public static Random ran;

	public static char getRandChar() {
		char[] table = new char[] { 'x', 'd', 'o', 'l', 'c', 'k', 'd', 'o', 'c', 'k' };
		int len = table.length;
		ran = new Random();
		return table[ran.nextInt(len)];

	}

	public static void main(String[] args) {
		String target = "dock";
		int count = 0;
		for (char c : target.toCharArray()) {
			while (true) {
				count++;
				if (getRandChar() == c) {
					break;
				}
			}
		}
		System.out.println(count);
	}
}

package com.fanchen.groupsolve;

public class GCD {

	public static int findGCD(int a, int b) {
		return a == 0 ? b : findGCD(b % a, a);
	}

	public static void main(String[] args) {
		System.out.println(findGCD(30, 250));
	}
}

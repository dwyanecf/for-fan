package com.fanchen.clearmind.classto.test;

public class EggBasket {
	public static void main(String[] args) {
		int[] a = new int[10];
		for (int i = 1; i < a.length; i++) {
			a[i] = i;
		}
		for (int j = 0; j < a.length; j++) {
			if (isPrimeNumber(a[j])) {
				System.out.println("all prime number is " + a[j]);
			}

		}
	}

	public static boolean isPrimeNumber(int n) {
		if (n == 0 || n == 1 || n == 2) {
			return false;
		}
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
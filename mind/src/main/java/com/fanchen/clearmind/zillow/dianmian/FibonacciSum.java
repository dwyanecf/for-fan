package com.fanchen.clearmind.zillow.dianmian;

public class FibonacciSum {
	static int calculateSum(int n) {
		if (n <= 1)
			return n;

		int[] fib = new int[n + 1];
		fib[0] = 0;
		fib[1] = 1;
		int sum = fib[0] + fib[1];
		for (int i = 2; i <= n; n++) {
			fib[i] = fib[i - 1] + fib[i - 2];
			sum += fib[i];
		}
		return sum;
	}
}

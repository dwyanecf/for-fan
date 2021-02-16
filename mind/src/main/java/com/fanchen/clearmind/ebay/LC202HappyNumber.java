package com.fanchen.clearmind.ebay;

import java.util.HashSet;
import java.util.Set;

public class LC202HappyNumber {
	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		while (n > 1 && !set.contains(n)) {
			set.add(n);
			n = getSum(n);
		}
		return n == 1;
	}

	private int getSum(int n) {
		int cur = 0;
		int sum = 0;
		while (n > 0) {
			cur = n % 10;
			sum += cur * cur;
			n /= 10;
		}
		return sum;
	}

}

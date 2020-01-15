package com.fanchen.groupsolve;

import java.util.ArrayList;
import java.util.List;

public class AllPrimeNumbers {
	public static List<Integer> primeFactors(int n) {
		List<Integer> list = new ArrayList<>();
		while (n % 2 == 0) {
			list.add(2);
			n /= 2;
		}

		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			while (n % i == 0) {
				list.add(i);
				n /= i;
			}
		}
		if (n > 2) {
			list.add(n);
		}
		System.out.println(list.toString());
		return list;

	}

	public static void main(String[] args) {
		primeFactors(315);
	}
}

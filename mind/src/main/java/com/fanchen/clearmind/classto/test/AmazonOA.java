package com.fanchen.clearmind.classto.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AmazonOA {

	public static List<String> orders(int n, List<String> orderList) {
		List<String> res = new ArrayList<>();
		List<String> primeOrders = new ArrayList<>();
		List<String> nonPrimeOrders = new ArrayList<>();

		for (String order : orderList) {
			if (isPrime(order)) {
				primeOrders.add(order);
			} else {
				nonPrimeOrders.add(order);
			}
		}
		Collections.sort(primeOrders,
				(a, b) -> a.substring(a.indexOf(" ") + 1).equals(b.substring(b.indexOf(" ") + 1))
						? a.substring(0, a.indexOf(" ")).compareTo(b.substring(0, b.indexOf(" ")))
						: a.substring(a.indexOf(" ") + 1).compareTo(b.substring(b.indexOf(" ") + 1)));

		res.addAll(primeOrders);
		res.addAll(nonPrimeOrders);

		for (String s : res) {
			System.out.println(s);

		}
		return orderList;

	}

	private static boolean isPrime(String order) {
		int index = order.indexOf(" ") + 1;
		return Character.isLetter(order.charAt(index));
	}

	public static void main(String[] args) {
		List<String> supplierNames = Arrays.asList("zld 93 12", "fp kindle book", "10a echo show", "17g 12 25 6",
				"abl kindle book", "125 echo dot second generation");
		int n = 5;
		orders(5, supplierNames);
	}
}

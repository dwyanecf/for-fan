package com.fanchen.clearmind.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class StreamSort {

	public static void main(String[] args) {
		Integer[] array = new Integer[] { 99, 44, 154, 2, 14, 22 };
		Arrays.sort(array, (a, b) -> b - a);
		for (Integer i : array) {
			System.out.println(i);
		}
		int[] A = { 3, 1, 2, 0 };
		int[] sorted = IntStream.of(A).boxed().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();
		for (Integer i : sorted) {
			System.out.println(i);
		}
	}
}

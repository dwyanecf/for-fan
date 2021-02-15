package com.fanchen.clearmind.ebay;

public class LC1122RelativeSortArray {
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		int[] count = new int[1001];
		for (int i : arr1) {
			count[i]++;
		}
		int index = 0;
		for (int n : arr2) {
			while (count[n]-- > 0) {
				arr1[index++] = n;
			}
		}
		for (int i = 0; i < count.length; i++) {
			while (count[i]-- > 0) {
				arr1[index++] = i;
			}
		}
		return arr1;

	}

}

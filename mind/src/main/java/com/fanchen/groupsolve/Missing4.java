/*
 * Copyright (C) 2020 Copart, Inc. All rights reserved.
 */
package com.fanchen.groupsolve;

import java.util.Arrays;

/**
 * @author fachen
 *
 */
public class Missing4 {

	public static void missing4(int[] arr) {
		int[] helper = new int[4];
		Arrays.fill(helper, 1);

		for (int i = 0; i < arr.length; i++) {
			int val = Math.abs(arr[i]) - 1;

			if (val < arr.length)
				arr[val] = -arr[val];

			else {
				helper[val - arr.length] = -1;

			}
		}

		for (int i = 0; i < arr.length; i++)
			if (arr[i] > 0)
				System.out.print(i + 1 + " ");
		for (int i = 0; i < helper.length; i++)
			if (helper[i] > 0)
				System.out.print(arr.length + i + 1 + " ");

		return;
	}

	// Driver code
	public static void main(String[] args) {
		int[] arr = { 1, 5 };
		missing4(arr);
	}
}

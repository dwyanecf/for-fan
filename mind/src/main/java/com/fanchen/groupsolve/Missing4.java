/*
 * Copyright (C) 2020 Copart, Inc. All rights reserved.
 */
package com.fanchen.groupsolve;

import java.util.Arrays;

/**
 * @author Fan Chen
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
		int[] arr = { 1, 7, 3, 12, 5, 10, 8, 4, 9 };
//		missing4(arr);
		missing4Numbers(arr);
	}

	public static void missing4Numbers(int[] arr) {
		int[] missed = new int[4];
		Arrays.fill(missed, 1);
		for (int i = 0; i < arr.length; i++) {
			int index = Math.abs(arr[i]) - 1;
			if (index < arr.length) {
				arr[index] = -arr[index];
			} else {
				missed[index - arr.length] = -1;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				System.out.println(i + 1 + " ");
			}
		}
		for (int i = 0; i < missed.length; i++) {
			if (missed[i] > 0) {
				System.out.println(arr.length + i + 1 + " ");
			}
		}
	}
}

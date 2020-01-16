package com.fanchen.groupsolve;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Missing4 {

	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> ret = new ArrayList<Integer>();

		for (int i = 0; i < nums.length; i++) {
			int val = Math.abs(nums[i]) - 1;
			if (nums[val] > 0) {
				nums[val] = -nums[val];
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				ret.add(i + 1);
			}
		}
		return ret;
	}

	public static void missing4(int[] arr) {

		int[] helper = new int[3];
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
		int[] arr = { 4, 3, 2, 7, 8, 2, 3, 1 };
//		System.out.println(findDisappearedNumbers(arr));
		missing4(new int[] { 4,5});
	}
}

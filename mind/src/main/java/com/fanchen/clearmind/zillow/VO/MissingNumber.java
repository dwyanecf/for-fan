package com.fanchen.clearmind.zillow.VO;

import java.util.Arrays;

public class MissingNumber {
	public int missingNumber(int[] nums) {
		int total = nums.length * (nums.length + 1) / 2;
		for (int n : nums) {
			total -= n;
		}
		return total;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 7, 3, 12, 5, 10, 8, 4 };
		missingNumbers(nums, 5);
	}

	public static void missingNumbers(int[] nums, int n) {
		int[] missed = new int[n];
		int[] res = new int[n];
		int p = 0;
		Arrays.fill(missed, 1);
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (index < nums.length) {
				nums[index] = -nums[index];
			} else {
				missed[index - nums.length] = -1;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
//				System.out.println(i + 1 + " ");
				res[p++] = i + 1;
			}
		}
		for (int i = 0; i < missed.length; i++) {
			if (missed[i] > 0) {
//				System.out.println(nums.length + i + 1 + " ");
				res[p++] = nums.length + i + 1;
			}
		}
		for (int r : res) {
			System.out.println(r);
		}

	}
}

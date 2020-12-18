package com.fanchen.clearmind.leetcode.yama.vo;

public class LC41FirstMissingPositive {
	public static int firstMissingPositive(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= 0 || nums[i] > n) {
				nums[i] = n + 1;
			}
		}

		for (int i = 0; i < n; i++) {
			int num = Math.abs(nums[i]);
			if (num > n)
				continue;
			num--;
			if (nums[num] > 0) {
				nums[num] = -1;
			}

		}

		for (int i = 0; i < n; i++) {
			if (nums[i] >= 0) {
				return i + 1;
			}
		}

		return n + 1;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 2, 2 };
		firstMissingPositive(a);
	}
	
//	https://leetcode.com/problems/first-missing-positive/discuss/319270/Explanation-of-crucial-observation-needed-to-deduce-algorithm
}

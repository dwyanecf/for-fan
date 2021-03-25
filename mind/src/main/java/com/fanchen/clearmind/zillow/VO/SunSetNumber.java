package com.fanchen.clearmind.zillow.VO;

public class SunSetNumber {

	public static int seeSunSet(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int res = 0;
		int curMax = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= curMax) {
				res++;
			}
			curMax = Math.max(curMax, nums[i]);
		}

		return res;

	}

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 2, 4, 3, 5 };

		System.out.println(seeSunSet(nums));
		// [ 1,2,3,2,4,3,5]

	}
}

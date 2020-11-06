package com.fanchen.clearmind.leetcode.yama.vo;

public class LC238 {

	/**
	 * Input: [1,2,3,4] Output: [24,12,8,6]
	 */
	public int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];
		int temp = 1;
		for (int i = 0; i < nums.length; i++) {
			// [1,2,3,4]
			// [1,1,2,6]
			res[i] = temp;
			temp *= nums[i];
		}
		temp = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
//			res [1,1,2,6]
//			nums[1,2,3,4]
			res[i] *= temp;
			temp *= nums[i];
		}

		return res;
	}
}

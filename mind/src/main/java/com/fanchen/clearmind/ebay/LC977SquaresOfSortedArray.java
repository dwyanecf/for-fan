package com.fanchen.clearmind.ebay;

public class LC977SquaresOfSortedArray {
	public int[] sortedSquares(int[] nums) {

		if (nums == null || nums.length == 0)
			return new int[0];
		int[] res = new int[nums.length];

		if (nums[0] >= 0) {
			for (int i = 0; i < res.length; i++) {
				res[i] = nums[i] * nums[i];
			}
		} else {
			int lo = 0;
			int hi = nums.length - 1;

			int curIndex = nums.length - 1;
			while (curIndex >= 0) {
				if (Math.abs(nums[lo]) > Math.abs(nums[hi])) {
					res[curIndex] = nums[lo] * nums[lo];
					lo++;
				} else {
					res[curIndex] = nums[hi] * nums[hi];
					hi--;
				}
				curIndex--;
			}

		}

		return res;

	}

}

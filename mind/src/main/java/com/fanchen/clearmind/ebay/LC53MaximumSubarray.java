package com.fanchen.clearmind.ebay;

public class LC53MaximumSubarray {
	public int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;
		int cur = 0;
		for (int n : nums) {
			cur += n;
			max = Math.max(cur, max);
			if (cur < 0) {
				cur = 0;
			}
		}
		return max;
	}
}

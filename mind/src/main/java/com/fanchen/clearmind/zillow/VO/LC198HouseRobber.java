package com.fanchen.clearmind.zillow.VO;

public class LC198HouseRobber {
	public int rob(int[] nums) {
		int rob = 0;
		int notRob = 0;
		for (int n : nums) {
			int temp = notRob;
			notRob = Math.max(rob, notRob);
			rob = temp + n;

		}
		return Math.max(rob, notRob);
	}
}

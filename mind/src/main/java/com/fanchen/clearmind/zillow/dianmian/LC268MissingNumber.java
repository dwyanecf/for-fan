package com.fanchen.clearmind.zillow.dianmian;

import java.util.Arrays;

public class LC268MissingNumber {
	public int missingNumber(int[] nums) {

		return (nums.length) * (nums.length + 1) / 2 - Arrays.stream(nums).sum();

	}
}

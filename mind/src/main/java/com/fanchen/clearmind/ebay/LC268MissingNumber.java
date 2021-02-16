package com.fanchen.clearmind.ebay;

import java.util.Arrays;

public class LC268MissingNumber {
	public int missingNumber(int[] nums) {

		return (nums.length) * (nums.length + 1) / 2 - Arrays.stream(nums).sum();
	}
}

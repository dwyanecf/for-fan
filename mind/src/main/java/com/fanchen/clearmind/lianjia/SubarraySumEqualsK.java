/*
 * Copyright (C) 2019 Copart, Inc. All rights reserved.
 */
package com.fanchen.clearmind.lianjia;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Fan Chen
 * 
 * 
 *         Given an array of integers and an integer k, you need to find the
 *         total number of continuous subarrays whose sum equals to k.
 * 
 *         Example 1: Input:nums = [1,1,1], k = 2 Output: 2
 * 
 *         Note: The length of the array is in range [1, 20,000]. The range of
 *         numbers in the array is [-1000, 1000] and the range of the integer k
 *         is [-1e7, 1e7].
 *
 */
public class SubarraySumEqualsK {
	public int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> preSum = new HashMap<>();
		preSum.put(0, 1);
		int ans = 0;
		int sum = 0;
		for (int n : nums) {
			sum += n;
			if (preSum.containsKey(sum - k)) {
				ans += preSum.get(sum - k);
			}
			preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
		}
		return ans;
	}
}

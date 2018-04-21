package com.fanchen.clearmind.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of non-negative integers nums, the degree of this
 * array is defined as the maximum frequency of any one of its elements.
 * 
 * Your task is to find the smallest possible length of a (contiguous) subarray
 * of nums, that has the same degree as nums.
 * 
 * Example 1: Input: [1, 2, 2, 3, 1] Output: 2 Explanation: The input array has
 * a degree of 2 because both elements 1 and 2 appear twice. Of the subarrays
 * that have the same degree: [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1,
 * 2, 2], [2, 2, 3], [2, 2] The shortest length is 2. So return 2. Example 2:
 * Input: [1,2,2,3,1,4,2] Output: 6
 * 
 * @author fan
 *
 */
public class DegreeOfArray {
	public int findShortestSubArray(int[] nums) {
		int degree = 0;
		int n = nums.length;
		int minSize = n;
		Map<Integer, Integer> frequency = new HashMap<>();
		Map<Integer, Integer[]> index = new HashMap<>();
		for (int i = 0; i < n; i++) {
			frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);
			degree = Math.max(degree, frequency.get(nums[i]));

			if (index.get(nums[i]) == null) {
				Integer[] array = new Integer[2];
				array[0] = i;
				index.put(nums[i], array);
			}
			index.get(nums[i])[1] = i;
		}
		for (int key : frequency.keySet()) {
			if (frequency.get(key) != degree)
				continue;

			minSize = Math.min(minSize, index.get(key)[1] - index.get(key)[0] + 1);
		}
		return minSize;
	}
}

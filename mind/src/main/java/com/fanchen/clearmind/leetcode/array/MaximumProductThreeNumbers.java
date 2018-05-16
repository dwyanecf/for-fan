package com.fanchen.clearmind.leetcode.array;

import java.util.Arrays;

/**
 * 
 * Given an integer array, find three numbers whose product is maximum and
 * output the maximum product.
 * 
 * Example 1: Input: [1,2,3] Output: 6 Example 2: Input: [1,2,3,4] Output: 24
 * Note: The length of the given array will be in range [3,104] and all elements
 * are in the range [-1000, 1000]. Multiplication of any three numbers in the
 * input won't exceed the range of 32-bit signed integer.
 * 
 * @author fan
 *
 */
public class MaximumProductThreeNumbers {
	public int maximumProduct(int[] nums) {
		int n = nums.length;
		Arrays.sort(nums);
		if (nums[1] >= 0 || nums[n - 1] <= 0) {
			return nums[n - 1] * nums[n - 2] * nums[n - 3];
		}
		int min1 = nums[0], min2 = nums[1];
		int max1 = nums[n - 1], max2 = nums[n - 2], max3 = nums[n - 3];
		return Math.max(min1 * min2 * max1, max1 * max2 * max3);
	}
}

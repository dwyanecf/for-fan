package com.fanchen.clearmind.leetcode.old;

import java.util.Arrays;

/**
 * There are N children standing in a line. Each child is assigned a rating
 * value.
 * 
 * You are giving candies to these children subjected to the following
 * requirements:
 * 
 * Each child must have at least one candy. Children with a higher rating get
 * more candies than their neighbors.
 * 
 * What is the minimum candies you must give?
 * 
 * @author fan
 *
 */
public class Candy {

	public int candy(int[] ratings) {

		int n = ratings.length;
		int[] nums = new int[n];
		Arrays.fill(nums, 1);
		for (int i = 1; i < n; i++) {
			if (ratings[i] > ratings[i - 1]) {
				nums[i] = nums[i - 1] + 1;
			}
		}

		for (int i = n - 1; i >= 1; i--) {
			if (ratings[i] < ratings[i - 1]) {
				nums[i - 1] = Math.max(nums[i] + 1, nums[i - 1]);
			}
		}
		int res = 0;
		for (int num : nums) {
			res += num;
		}
		return res;
	}
}

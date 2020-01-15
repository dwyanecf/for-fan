package com.fanchen.clearmind.lianjia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the sum
 * of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		int n = nums.length;
		for (int i = 0; i < n - 2; i++) {
			if (i != 0 && nums[i] == nums[i - 1])
				continue;
			if (nums[i] > 0)
				break;
			for (int j = i + 1, k = n - 1; j < k && j < n - 1;) {
				if (j != i + 1 && nums[j] == nums[j - 1]) {
					j++;
					continue;
				}
				if (nums[i] + nums[j] > 0)
					break;
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == 0) {
					list.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++;
				} else if (sum < 0) {
					j++;
				} else {
					k--;
				}
			}
		}
		return list;
	}
}

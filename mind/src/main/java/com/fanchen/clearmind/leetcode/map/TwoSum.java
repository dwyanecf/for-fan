package com.fanchen.clearmind.leetcode.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Example: Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 * 
 * @author fan
 *
 */
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] res = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				res[0] = map.get(nums[i]);
				res[1] = i;
				return res;
			} else {
				map.put(target - nums[i], i);
			}
		}
		return res;
	}
}

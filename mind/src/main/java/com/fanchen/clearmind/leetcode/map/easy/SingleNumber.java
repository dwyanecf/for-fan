package com.fanchen.clearmind.leetcode.map.easy;

/**
 * 
 * 
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * 
 * @author fan
 *
 */
public class SingleNumber {

	public int singleNumber(int[] nums) {

		int res = 0;
		for (int num : nums) {
			res = res ^ num;
		}
		return res;
	}
}

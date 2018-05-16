package com.fanchen.clearmind.leetcode.array;

/**
 * Max Consecutive Ones Given a binary array, find the maximum number of
 * consecutive 1s in this array.
 * 
 * Example 1: Input: [1,1,0,1,1,1] Output: 3 Explanation: The first two digits
 * or the last three digits are consecutive 1s. The maximum number of
 * consecutive 1s is 3.
 * 
 * @author fan
 *
 */
public class MaxConsecutiveOnes {
	public int findMaxConsecutiveOnes(int[] nums) {
		int max = 0;
		int currentMax = 0;
		for (int i : nums) {
			if (i == 1) {
				currentMax++;
				max = Math.max(currentMax, max);
			} else {
				currentMax = 0;
			}
		}
		return max;
	}
}

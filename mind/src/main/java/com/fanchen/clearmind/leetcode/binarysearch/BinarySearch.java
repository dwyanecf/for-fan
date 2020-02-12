package com.fanchen.clearmind.leetcode.binarysearch;

/**
 * Given a sorted (in ascending order) integer array nums of n elements and a
 * target value, write a function to search target in nums. If target exists,
 * then return its index, otherwise return -1.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [-1,0,3,5,9,12], target = 9 Output: 4 Explanation: 9 exists in
 * nums and its index is 4
 * 
 * @author Fan Chen
 *
 */
public class BinarySearch {
	public int search(int[] nums, int target) {
		int lo = 0;
		int hi = nums.length;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return -1;
	}
}

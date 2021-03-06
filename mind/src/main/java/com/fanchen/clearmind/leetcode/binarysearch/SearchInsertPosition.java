package com.fanchen.clearmind.leetcode.binarysearch;

/**
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * <p>
 * You may assume no duplicates in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,5,6], 5 Output: 2 Example 2:
 * <p>
 * Input: [1,3,5,6], 2 Output: 1 Example 3:
 * <p>
 * Input: [1,3,5,6], 7 Output: 4 Example 4:
 * <p>
 * Input: [1,3,5,6], 0 Output: 0
 */
public class SearchInsertPosition {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5, 6 };
		searchInsert(nums, 4);
	}

	// 此为右闭
	public static int searchInsert(int[] nums, int target) {

		int n = nums.length;
		int lo = 0;
		int hi = n;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] > target) {
				hi = mid;
			} else if (nums[mid] < target) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return lo;

	}
}

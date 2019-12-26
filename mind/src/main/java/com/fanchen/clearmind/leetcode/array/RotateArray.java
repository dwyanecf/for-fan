package com.fanchen.clearmind.leetcode.array;

/**
 * Rotate an array of n elements to the right by k steps.
 * <p>
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to
 * [5,6,7,1,2,3,4].
 * <p>
 * Note: Try to come up as many solutions as you can, there are at least 3
 * different ways to solve this problem.
 * <p>
 * [show hint]
 * <p>
 * Hint: Could you do it in-place with O(1) extra space?
 * <p>
 * Related problem: Reverse Words in a String II
 */
public class RotateArray {
	public void rotate(int[] nums, int k) {
		int n = nums.length;
		int[] res = new int[n];
		k = k % n;
		if (k == 0)
			return;
		for (int i = 0; i < n; i++) {
			res[(i + k) % n] = nums[i];
		}
		for (int i = 0; i < n; i++) {
			nums[i] = res[i];
		}

	}
}

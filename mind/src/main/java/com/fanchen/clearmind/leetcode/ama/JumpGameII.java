package com.fanchen.clearmind.leetcode.ama;

public class JumpGameII {
	/**
	 * Given an array of non-negative integers, you are initially positioned at the
	 * first index of the array.
	 * 
	 * Each element in the array represents your maximum jump length at that
	 * position.
	 * 
	 * Your goal is to reach the last index in the minimum number of jumps.
	 * 
	 * Example:
	 * 
	 * Input: [2,3,1,1,4] Output: 2 Explanation: The minimum number of jumps to
	 * reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the
	 * last index.
	 */
	public static int jump(int[] nums) {
		int res = 0;
		int cur = 0;
		int farthest = 0;
		for (int i = 0; i < nums.length; i++) {
			farthest = Math.max(farthest, nums[i] + i);
			if (cur == i) {
				res++;
				cur = farthest;
			}
			if (cur >= nums.length - 1) {
				break;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		jump(new int[] { 2, 3, 1, 1, 4 });
	}
}

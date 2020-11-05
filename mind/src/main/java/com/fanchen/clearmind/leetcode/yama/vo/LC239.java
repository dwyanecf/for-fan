package com.fanchen.clearmind.leetcode.yama.vo;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC239 {

	// [1,3,-1,-3,5,3,6,7] , k =3
	// [3,3,5,5,6,7]
	public static int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || k <= 0)
			return new int[0];

		// store index
		Deque<Integer> q = new ArrayDeque<>();
		int[] res = new int[nums.length - k + 1];
		for (int i = 0; i < nums.length; i++) {

			// remove numbers out of range k
			while (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
			// remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
				q.pollLast();
			}
			q.offer(i);
			// q contains index... num contains content
			if (i - k + 1 >= 0) {
				res[i - k + 1] = nums[q.peek()];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3);
	}
	// https://leetcode.com/problems/sliding-window-maximum/
}

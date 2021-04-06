package com.fanchen.clearmind.zillow.VO;

import java.util.Arrays;
import java.util.Stack;

public class LC503NextGreaterElement {
	public int[] nextGreaterElements(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		Stack<Integer> stack = new Stack<>();
		Arrays.fill(res, -1);
		for (int i = 0; i < n * 2; i++) {
			while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
				res[stack.pop()] = nums[i % n];
			}
			stack.push(i % n);
		}
		return res;
	}
}

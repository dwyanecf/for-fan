package com.fanchen.clearmind.leetcode.map;

import java.util.Stack;

/**
 * Given a list of daily temperatures, produce a list that, for each day in the
 * input, tells you how many days you would have to wait until a warmer
 * temperature. If there is no future day for which this is possible, put 0
 * instead.
 * 
 * For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73],
 * your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * 
 * Note: The length of temperatures will be in the range [1, 30000]. Each
 * temperature will be an integer in the range [30, 100].
 * 
 * @author fan
 *
 */
public class DailyTemperatures {
	public static int[] dailyTemperatures(int[] temperatures) {
		Stack<Integer> stack = new Stack<>();
		int n = temperatures.length;
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
				int index = stack.pop();
				res[index] = i - index;
			}
			stack.push(i);
		}
		return res;
	}

	public static int[] dailyTemperature(int[] temperatures) {
		Stack<Integer> stack = new Stack<>();
		int[] res = new int[temperatures.length];
		for (int i = 0; i < temperatures.length; i++) {
			while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
				int index = stack.pop();
				res[index] = i - index;
			}
			stack.push(i);
		}
		return res;

	}

	public static void main(String[] args) {
		int[] test = new int[] { 73, 74, 75, 71, 69, 72, 76, 73 };
		int[] res = dailyTemperature(test);
		for (int n : res) {
			System.out.println(n);
		}
	}

}

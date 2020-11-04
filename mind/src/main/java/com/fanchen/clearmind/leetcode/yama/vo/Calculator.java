package com.fanchen.clearmind.leetcode.yama.vo;

import java.util.Stack;

public class Calculator {
	/**
	 * Input: "(1+(4+5+2)-3)+(6+8)" Output: 23
	 * 
	 * @param s
	 * @return
	 */
	public static int calculate(String s) {
		if (s.length() < 1)
			return 0;
		Stack<Integer> stack = new Stack<>();

		int sum = 0;
		int sign = 1;
		int pre = 0;
		stack.push(sign);
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				pre = pre * 10 + c - '0';
			} else if (c == '+' || c == '-') {
				sum += sign * pre;
				sign = c == '+' ? stack.peek() : -1 * stack.peek();
				pre = 0;
			} else if (c == '(') {
				stack.push(sign);
			} else if (c == ')') {
				stack.pop();
			}
		}
		sum += sign * pre;
		return sum;
	}
	public static void main(String[] args) {
		calculate("(1+(4+5+2)-3)+(6+8)");
	}
}

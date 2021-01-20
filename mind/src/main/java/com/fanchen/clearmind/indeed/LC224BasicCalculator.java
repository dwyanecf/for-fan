package com.fanchen.clearmind.indeed;

import java.util.Stack;

public class LC224BasicCalculator {

	// 给输入为string，例如"2+3-999"，之包含+-操作，返回计算结果。
	public static int basicCalculator1(String expression) {
		char[] chars = expression.toCharArray();
		int num = 0, sum = 0, sign = 1; // 1 for +, -1 for -
		for (int i = 0; i < chars.length; i++) {
			char cur = chars[i];
			if (Character.isDigit(cur))
				num = num * 10 + Character.getNumericValue(cur);
			else if (cur == '+' || cur == '-') {
				sum += sign * num;
				num = 0;
				sign = (cur == '+') ? 1 : -1;
			}
		}
		if (num != 0)
			sum += sign * num;
		return sum;
	}

	public static int basicCalculator2(String expression) {
		char[] chars = expression.toCharArray();
		int num = 0, sum = 0, sign = 1;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < chars.length; i++) {
			char cur = chars[i];
			if (Character.isDigit(cur))
				num = num * 10 + Character.getNumericValue(cur);
			else if (cur == '+' || cur == '-') {
				sum += num * sign;
				num = 0;
				sign = (cur == '+') ? 1 : -1;
			} else if (cur == '(') {
				stack.push(sum);
				stack.push(sign);
				sum = 0;
				num = 0;
				sign = 1;
			} else if (cur == ')') {
				sum += num * sign;
				sum = sum * stack.pop() + stack.pop();
				num = 0;
				// 3 + ( - 9 ) + 5
				// - 6
			}
		}
		if (num != 0)
			sum += sign * num;
		return sum;
	}

}

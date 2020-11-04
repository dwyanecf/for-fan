package com.fanchen.clearmind.leetcode.yama.vo;

import java.util.Stack;

public class LC772Calculator {

	/**
	 * Implement a basic calculator to evaluate a simple expression string.
	 * 
	 * The expression string may contain open ( and closing parentheses ), the plus
	 * + or minus sign -, non-negative integers and empty spaces .
	 * 
	 * The expression string contains only non-negative integers, +, -, *, /
	 * operators , open ( and closing parentheses ) and empty spaces . The integer
	 * division should truncate toward zero.
	 * 
	 * You may assume that the given expression is always valid. All intermediate
	 * results will be in the range of [-2147483648, 2147483647]
	 * 
	 *  "1 + 1" = 2
		" 6-4 / 2 " = 4
		"2*(5+5*2)/3+(6/2+8)" = 21
		"(2+6* 3+5- (3*14/7+2)*5)+3"=-12
	 */

	public static int calculate(String s) {
		if (s == null)
			return 0;
		s = s.replace(" ", "");
		if (s.length() == 0)
			return 0;
		Stack<Integer> stack = new Stack<>();
		char sign = '+';
		int sum = 0;
		int i = 0;
		int pre = 0;
		while (i < s.length()) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				pre = pre * 10 + (c - '0');
			} else if (c == '(') {
				int j = getIndex(s.substring(i));
				pre = calculate(s.substring(i + 1, i + j));
				i += j;
			}
			if (i == s.length() - 1 || !Character.isDigit(c)) {
				switch (sign) {
				case '+':
					stack.push(pre);
					break;
				case '-':
					stack.push(-pre);
					break;
				case '*':
					stack.push(stack.pop() * pre);
					break;
				case '/':
					stack.push(stack.pop() / pre);
					break;
				}
				pre = 0;
				sign = c;
			}
			i++;

		}
		while (!stack.isEmpty()) {
			sum += stack.pop();
		}
		return sum;

	}

	static int getIndex(String s) {
		int level = 0;
		int i = 0;
		for (i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				level++;
			} else if (s.charAt(i) == ')') {
				level--;
				if (level == 0)
					break;
			}
		}
		return i;
	}
    
    public static void main(String[] args) {

		System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3"));
	}
    
    //https://blog.csdn.net/haozhugogo/article/details/94152390
}

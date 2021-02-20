package com.fanchen.clearmind.ebay;

import java.util.Stack;

public class LC20ValidParentheses {
	public boolean isValid(String s) {

		char[] chars = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (char c : chars) {
			if (c == ')') {
				if (stack.isEmpty() || stack.pop() != '(') {
					return false;
				}

			} else if (c == ']') {
				if (stack.isEmpty() || stack.pop() != '[') {
					return false;
				}
			} else if (c == '}') {
				if (stack.isEmpty() || stack.pop() != '{') {
					return false;
				}
			} else {
				stack.push(c);
			}

		}
		return stack.isEmpty();

	}
}

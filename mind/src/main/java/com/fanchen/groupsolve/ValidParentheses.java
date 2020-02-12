/*
 * Copyright (C) 2019 Copart, Inc. All rights reserved.
 */
package com.fanchen.groupsolve;

import java.util.Stack;

/**
 * @author Fan Chen
 *
 */
public class ValidParentheses {

	public boolean isValid(String s) {
		char[] chars = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (char c : chars) {
			if (c == ')') {
				if (stack.isEmpty()) {
					return false;
				}
				if (stack.pop() != '(') {
					return false;
				}

			}
			if (c == ']') {
				if (stack.isEmpty()) {
					return false;
				}
				if (stack.pop() != '[') {
					return false;
				}

			}
			if (c == '}') {
				if (stack.isEmpty()) {
					return false;
				}
				if (stack.pop() != '{') {
					return false;
				}

			}
			stack.push(c);

		}
		return stack.isEmpty();
	}

}

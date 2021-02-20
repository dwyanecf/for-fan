package com.fanchen.clearmind.ebay;

import java.util.Stack;

public class LC155MinStack {
	Stack<Integer> stack;
	int min;

	/** initialize your data structure here. */
	public LC155MinStack() {
		stack = new Stack<>();
		min = Integer.MAX_VALUE;
	}

	public void push(int x) {
		if (x <= min) {
			stack.push(min);
			min = x;
		}
		stack.push(x);
	}

	public void pop() {
		if (stack.pop() == min) {
			min = stack.pop();
		}
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return min;
	}
}

package com.fanchen.clearmind.leetcode.yama.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.fanchen.clearmind.concept.ListNode;

public class LC1019 {
	public int[] nextLargerNodes(ListNode head) {
		ListNode cur = head;
		List<Integer> list = new ArrayList<>();
		while (cur != null) {
			list.add(cur.val);
			cur = cur.next;
		}
		int[] res = new int[list.size()];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < list.size(); i++) {
			while (!stack.isEmpty() && list.get(i) > list.get(stack.peek())) {
				res[stack.pop()] = list.get(i);
			}
			stack.push(i);
		}
		return res;
	}
}

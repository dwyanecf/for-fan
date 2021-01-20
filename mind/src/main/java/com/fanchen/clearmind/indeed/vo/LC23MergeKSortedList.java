package com.fanchen.clearmind.indeed.vo;

import java.util.PriorityQueue;

import com.fanchen.clearmind.concept.ListNode;

public class LC23MergeKSortedList {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		PriorityQueue<ListNode> q = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
		for (ListNode node : lists) {
			if (node != null) {
				q.offer(node);
			}
		}
		while (!q.isEmpty()) {
			cur.next = q.poll();
			cur = cur.next;
			if (cur.next != null) {
				q.offer(cur.next);
			}
		}
		return dummy.next;
	}
}

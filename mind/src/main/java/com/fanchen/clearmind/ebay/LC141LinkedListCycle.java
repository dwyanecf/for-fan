package com.fanchen.clearmind.ebay;

import com.fanchen.clearmind.concept.ListNode;

public class LC141LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}
}

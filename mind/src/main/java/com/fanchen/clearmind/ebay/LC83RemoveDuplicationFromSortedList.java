package com.fanchen.clearmind.ebay;

import com.fanchen.clearmind.concept.ListNode;

public class LC83RemoveDuplicationFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode begining = head;
		while (head.next != null) {
			if (head.val == head.next.val) {
				head.next = head.next.next;
			} else {
				head = head.next;
			}
		}
		return begining;
	}
}

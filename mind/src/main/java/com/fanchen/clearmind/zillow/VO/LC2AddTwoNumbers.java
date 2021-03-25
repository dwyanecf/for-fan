package com.fanchen.clearmind.zillow.VO;

import com.fanchen.clearmind.concept.ListNode;

public class LC2AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode cur = head;
		int sum = 0;
		int carry = 0;
		while (l1 != null || l2 != null) {
			sum += carry;
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			carry = sum / 10;
			cur.next = new ListNode(sum % 10);
			cur = cur.next;
			sum = 0;
		}
		if (carry > 0) {
			cur.next = new ListNode(carry);
		}
		return head.next;
	}
}

package com.fanchen.clearmind.leetcode.linkedlist;

import com.fanchen.clearmind.concept.ListNode;

/**
 * Remove all elements from a linked list of integers that have value val.
 * <p>
 * Example:
 * <p>
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */
public class RemoveLinkedListElements {
    // 2个指针 1个计res 1个计当前
    public ListNode removeElements(ListNode head, int val) {
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode pre = fake;
        ListNode cur = head;
        while (cur != null){
            if(cur.val == val){
                pre.next = cur.next;
            }else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return fake.next;
    }
}

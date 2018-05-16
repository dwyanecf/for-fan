package com.fanchen.clearmind.leetcode.linkedlist;

import com.fanchen.clearmind.concept.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        ListNode start = new ListNode(0);
        ListNode head = start;
        while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
                head.next=l1;
                l1=l1.next;
            }else{
                head.next=l2;
                l2=l2.next;
            }
            head = head.next;
        }
        if(l1 == null) head.next = l2;
        if(l2 == null) head.next = l1;
        return start.next;
    }
}

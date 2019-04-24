package com.fanchen.clearmind.lianjia;

import com.fanchen.clearmind.concept.ListNode;

/**
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next==null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast!=null){
            slow = slow.next;
        }
        slow = reverseList(slow);
        fast = head;
        while(slow!=null){
            if (slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
  }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}

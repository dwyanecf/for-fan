package com.fanchen.clearmind.lianjia;

import com.fanchen.clearmind.concept.ListNode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 *
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        int count = 0;
        ListNode pre = head;
        while (count != k && pre != null) {
            pre = pre.next;
            count++;
        }
        if (count == k) {
            pre = reverseKGroup(pre, k);
            while (count-- > 0) {
                ListNode next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            head = pre;
        }
        return head;
    }

//    public static void main(String[] args){
//      ListNode head = new ListNode(1);
//      ListNode cur = head;
//      for(int i =2;i<=5;i++){
//          cur.next = new ListNode(i);
//          cur = cur.next;
//      }
//        reverseKGroup(head,3);
//    }
}

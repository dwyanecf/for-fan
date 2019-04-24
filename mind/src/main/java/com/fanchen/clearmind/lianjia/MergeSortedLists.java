package com.fanchen.clearmind.lianjia;

import com.fanchen.clearmind.concept.ListNode;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class MergeSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return divide(lists, 0, lists.length -1);
    }

    private ListNode divide(ListNode[] lists, int lo, int hi) {
        if (lo == hi) return lists[lo];
        if (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            ListNode n1 = divide(lists, lo, mid);
            ListNode n2 = divide(lists, mid + 1, hi);
            return combine(n1, n2);
        }
        return null;
    }

    private ListNode combine(ListNode n1, ListNode n2) {
        if (n1 == null) return n2;
        if (n2 == null) return n1;
        if (n1.val < n2.val) {
            n1.next = combine(n1.next, n2);
            return n1;
        } else {
            n2.next = combine(n1, n2.next);
            return n2;
        }
    }

}

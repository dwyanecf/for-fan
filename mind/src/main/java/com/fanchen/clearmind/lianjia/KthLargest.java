package com.fanchen.clearmind.lianjia;

import java.util.PriorityQueue;

/**
 * Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 */
public class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return -1;
        }
        PriorityQueue<Integer> q = new PriorityQueue<>(k, (a, b) -> b - a);
        for (int num : nums) {
            q.offer(num);
        }
        for (int i = 0; i < k - 1; i++) {
            q.poll();
        }
        return q.peek();
    }

}

package com.fanchen.clearmind.leetcode.array;

import java.util.PriorityQueue;

/**
 * Kth Largest Element in an Array
 */
public class KthLargestElementinanArray {

    public int kthLargestElement(int k, int[] nums) {
        if (nums == null || nums.length == 0 || k == 0) {
            return -1;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, (a, b) -> b - a);
        for (int i = 0; i < nums.length; i++) {
            heap.offer(nums[i]);
        }
        for (int j = 0; j < k - 1; j++) {
            heap.poll();
        }
        return heap.peek();
    }

    public int kthLargestElements(int k, int[] nums) {
        if (nums == null || nums.length == 0 || k == 0) {
            return -1;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, (a, b) -> a-b);
        for (int i = 0; i < nums.length; i++) {
            heap.offer(nums[i]);
        }
        return heap.peek();
    }
}

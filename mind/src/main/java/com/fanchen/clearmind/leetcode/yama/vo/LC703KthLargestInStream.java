package com.fanchen.clearmind.leetcode.yama.vo;

import java.util.PriorityQueue;

public class LC703KthLargestInStream {

	PriorityQueue<Integer> q;
	int k;

	public LC703KthLargestInStream(int k, int[] nums) {
		this.k = k;
		q = new PriorityQueue<>(k);
		for (int n : nums) {
			q.offer(n);
		}
	}

	public int add(int val) {
		q.offer(val);
		while (q.size() > k) {
			q.poll();
		}
		return q.peek();
	}
}

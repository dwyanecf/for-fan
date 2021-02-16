package com.fanchen.clearmind.ebay;

import java.util.PriorityQueue;

public class LC703KthLargestNumInStream {

	PriorityQueue<Integer> q;
	int k;

	public LC703KthLargestNumInStream(int k, int[] nums) {
		this.k = k;
		q = new PriorityQueue<Integer>(k);
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

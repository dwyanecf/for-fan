package com.fanchen.clearmind.leetcode.yama.OA;

import java.util.PriorityQueue;

public class LC973 {
	public int[][] kClosest(int[][] points, int K) {
		PriorityQueue<int[]> data = new PriorityQueue<>(K,
				(int[] a1, int[] a2) -> a2[0] * a2[0] + a2[1] * a2[1] - a1[0] * a1[0] - a1[1] * a1[1]);
		for (int[] point : points) {
			data.add(point);
			if (data.size() > K) {
				data.poll();
			}
		}
		return data.toArray(new int[K][2]);
	}
}

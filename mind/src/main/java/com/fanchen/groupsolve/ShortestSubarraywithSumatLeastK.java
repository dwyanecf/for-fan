/*
 * Copyright (C) 2019 Copart, Inc. All rights reserved.
 */
package com.fanchen.groupsolve;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Fan Chen
 *
 */
public class ShortestSubarraywithSumatLeastK {

	/**
	 * Return the length of the shortest, non-empty, contiguous subarray of A with
	 * sum at least K.
	 * 
	 * If there is no non-empty subarray with sum at least K, return -1.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: A = [1], K = 1 Output: 1 Example 2:
	 * 
	 * Input: A = [1,2], K = 4 Output: -1 Example 3:
	 * 
	 * Input: A = [2,-1,2], K = 3 Output: 3
	 * 
	 * 
	 * @param A
	 * @param K
	 * @return
	 */
	public int shortestSubarray(int[] A, int K) {
		if (A == null || A.length == 0)
			return -1;
		int n = A.length;
		int[] B = new int[n + 1];
		for (int i = 0; i < n; i++) {
			B[i + 1] = B[i] + A[i];
		}
		Deque<Integer> d = new ArrayDeque<Integer>();
		int res = n + 1;
		for (int i = 0; i <= n; i++) {
			while (d.size() != 0 && B[i] - B[d.getFirst()] >= K) {
				res = Math.min(res, i - d.pollFirst());
			}
			while (d.size() != 0 && B[i] <= B[d.getLast()]) {
				d.pollLast();
			}
			d.offer(i);
		}
		return res > n ? -1 : res;
	}

	public static void main(String[] args) {
		ShortestSubarraywithSumatLeastK obj = new ShortestSubarraywithSumatLeastK();
		obj.shortestSubarray(new int[] { 2, -1, 2 }, 3);
	}
}

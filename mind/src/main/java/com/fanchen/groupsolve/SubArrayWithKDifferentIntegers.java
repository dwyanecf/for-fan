/*
 * Copyright (C) 2019 Copart, Inc. All rights reserved.
 */
package com.fanchen.groupsolve;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fachen
 *
 */
public class SubArrayWithKDifferentIntegers {
	/**
	 * Given an array A of positive integers, call a (contiguous, not necessarily
	 * distinct) subarray of A good if the number of different integers in that
	 * subarray is exactly K.
	 * 
	 * (For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)
	 * 
	 * Return the number of good subarrays of A.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: A = [1,2,1,2,3], K = 2 Output: 7 Explanation: Subarrays formed with
	 * exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2],
	 * [1,2,1,2]. Example 2:
	 * 
	 * Input: A = [1,2,1,3,4], K = 3 Output: 3 Explanation: Subarrays formed with
	 * exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
	 * 
	 * 
	 * Note:
	 * 
	 * 1 <= A.length <= 20000 1 <= A[i] <= A.length 1 <= K <= A.length Accepted
	 * 
	 * @param A
	 * @param K
	 * @return
	 */
	public int subarraysWithKDistinct(int[] A, int K) {
		return atMostK(A, K) - atMostK(A, K - 1);
	}

	int atMostK(int[] A, int K) {
		int left = 0;
		int res = 0;
		Map<Integer, Integer> count = new HashMap<>();
		for (int right = 0; right < A.length; ++right) {
			if (count.getOrDefault(A[right], 0) == 0)
				K--;
			count.put(A[right], count.getOrDefault(A[right], 0) + 1);
			while (K < 0) {
				count.put(A[left], count.get(A[left]) - 1);
				if (count.get(A[left]) == 0)
					K++;
				left++;
			}
			res += right - left + 1;
		}
		return res;
	}
}

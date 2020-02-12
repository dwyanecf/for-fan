/*
 * Copyright (C) 2019 Copart, Inc. All rights reserved.
 */
package com.fanchen.clearmind.concept.start.point;

/**
 * @author Fan Chen
 *
 */

/*
 * Given two integer arrays A and B, return the maximum length of an subarray
 * that appears in both arrays.
 * 
 * Example 1:
 * 
 * Input: A: [1,2,3,2,1] B: [3,2,1,4,7] Output: 3 Explanation: The repeated
 * subarray with maximum length is [3, 2, 1].
 * 
 * 
 * Note:
 * 
 * 1 <= len(A), len(B) <= 1000 0 <= A[i], B[i] < 100
 */
public class MaximumLengthofRepeatedSubarray {

	public int findLength(int[] A, int[] B) {
		int[][] dp = new int[A.length][B.length];
		int ans = 0;
		for (int i = 0; i <= A.length; i++) {
			for (int j = 0; j <= B.length; j++) {
				if (i == 0 || j == 0)
					continue;
				if (A[i - 1] == B[j - 1]) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
					ans = Math.max(ans, dp[i][j]);
				}
			}
		}
		return ans;
	}

}

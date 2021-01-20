package com.fanchen.clearmind.indeed;

import java.util.ArrayList;
import java.util.List;

public class LC718MaximumLengthRepeatedSubarray {

	/**
	 * 
	 * Given two integer arrays A and B, return the maximum length of an subarray
	 * that appears in both arrays.
	 * 
	 * Input: A: [1,2,3,2,1] B: [3,2,1,4,7] Output: 3 Explanation: The repeated
	 * subarray with maximum length is [3, 2, 1].
	 */

	public int findLength(int[] A, int[] B) {
		int[][] dp = new int[A.length + 1][B.length + 1];
		int max = 0;
		for (int i = 0; i <= A.length; i++) {
			for (int j = 0; j <= B.length; j++) {
				if (i == 0 || j == 0)
					continue;
				if (A[i - 1] == B[j - 1]) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		return max;
	}

	/*
	 *
	 *
	 * longest continuous common history 输入： 
	 * [ ["3234.html", "xys.html", "7hsaa.html"], // user1 
	 *  ["3234.html", "sdhsfjdsh.html", "xys.html", "7hsaa.html"] // user2 ], 
	 *  user1 and user2
	 * （指定两个user求intersect） 输出：["xys.html", "7hsaa.html"] 输出两个user的最长相同访问记录
	 */

	List<String> findLongestCommonString(String[] s1, String[] s2) {
		int n = s1.length;
		int m = s2.length;
		int[][] dp = new int[n + 1][m + 1];
		int maxLen = 0;
		List<String> result = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (s1[i - 1].equals(s2[j - 1])) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					if (dp[i][j] > maxLen) {
						maxLen = dp[i][j];
						result = new ArrayList<>();
						for (int k = j; k > j - maxLen; k--) {
							result.add(0, s2[k - 1]);
						}
					}
				} else {
					dp[i][j] = 0;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String[] s1 = { "3234.html", "xys.html", "7hsaa.html" };
		String[] s2 = { "3234.html", "sdhsfjdsh.html", "xys.html", "7hsaa.html" };
		LC718MaximumLengthRepeatedSubarray longestCommonString = new LC718MaximumLengthRepeatedSubarray();
		List<String> list = longestCommonString.findLongestCommonString(s1, s2);
		for (String str : list) {
			System.out.println(str);
		}
	}

}

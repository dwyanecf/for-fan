/*
 * Copyright (C) 2019 Copart, Inc. All rights reserved.
 */
package com.fanchen.clearmind.concept.start.point;

/**
 * @author fachen Given two strings text1 and text2, return the length of their
 *         longest common subsequence.
 * 
 *         A subsequence of a string is a new string generated from the original
 *         string with some characters(can be none) deleted without changing the
 *         relative order of the remaining characters. (eg, "ace" is a
 *         subsequence of "abcde" while "aec" is not). A common subsequence of
 *         two strings is a subsequence that is common to both strings.
 * 
 *         If there is no common subsequence, return 0.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: s1 = "abcde", s2 = "ace" Output: 3 Explanation: The longest
 *         common subsequence is "ace" and its length is 3. Example 2:
 * 
 *         Input: s1 = "abc", s2 = "abc" Output: 3 Explanation: The longest
 *         common subsequence is "abc" and its length is 3. Example 3:
 * 
 *         Input: s1 = "abc", s2 = "def" Output: 0 Explanation: There is no such
 *         common subsequence, so the result is 0.
 * 
 * 
 *         Constraints:
 * 
 *         1 <= text1.length <= 1000 1 <= text2.length <= 1000 The input strings
 *         consist of lowercase English characters only.
 */
public class LongestCommonSubsequence {

	public int longestCommonSubsequence(String A, String B) {
		int n = A.length();
		int m = B.length();
		int f[][] = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {

				if (A.charAt(i - 1) == B.charAt(j - 1)) {
					f[i][j] = f[i - 1][j - 1] + 1;
				} else {
					f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
				}

			}
		}
		return f[n][m];
	}
}

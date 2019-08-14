package com.fanchen.clearmind.leetcode.ama;

public class LongestSubStringWithAtMostKDistinct {

	/**
	 * Given a string, find the length of the longest substring T that contains at
	 * most k distinct characters.
	 * 
	 * Example 1:
	 * 
	 * Input: s = "eceba", k = 2 Output: 3 Explanation: T is "ece" which its length
	 * is 3. Example 2:
	 * 
	 * Input: s = "aa", k = 1 Output: 2 Explanation: T is "aa" which its length is
	 * 2.
	 * 
	 * @param s
	 * @param k
	 * @return
	 */
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		int count = 0;
		int l = 0;
		int[] appear = new int[256];
		int res = 0;
		for (int r = 0; r < s.length(); r++) {
			if (appear[s.charAt(r)]++ == 0)
				count++;
			if (count > k) {
				while (--appear[s.charAt(l++)] > 0);
				count--;
			}
			res = Math.max(res, r - l + 1);
		}
		return res;
	}
}

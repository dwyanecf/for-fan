package com.fanchen.clearmind.leetcode.yama;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstringAmazon {
	/**
	 * Given a string S and a string T, find the minimum window in S which will
	 * contain all the characters in T in complexity O(n).
	 * 
	 * Example:
	 * 
	 * Input: S = "ADOBECODEBANC", T = "ABC" Output: "BANC" Note:
	 * 
	 * If there is no such window in S that covers all characters in T, return the
	 * empty string "". If there is such window, you are guaranteed that there will
	 * always be only one unique minimum window in S.
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public String minWindow(String s, String t) {
		if (s == null || s.length() == 0 || t.length() > s.length())
			return "";

		Map<Character, Integer> map = new HashMap<>();
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int count = 0;
		int l = 0;
		int index = 0;
		int minLen = s.length() + 1;
		for (int r = 0; r < s.length(); r++) {
			if (map.containsKey(s.charAt(r))) {
				map.put(s.charAt(r), map.get(s.charAt(r)) - 1);
				if (map.get(s.charAt(r)) >= 0) {
					count++;
				}
			}
			while (count == t.length()) {
				int len = r - l + 1;
				if (len < minLen) {
					minLen = len;
					index = l;
				}
				if (map.containsKey(s.charAt(l))) {
					map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
					if (map.get(s.charAt(l)) > 0) {
						count--;
					}
				}
				l++;
			}
		}
		if (minLen > s.length())
			return "";
		return s.substring(index, index + minLen);

	}
}

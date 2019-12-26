package com.fanchen.clearmind.lianjia;

import java.util.HashMap;
import java.util.Map;

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
 */
public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		if (s == null || t == null || s.length() < t.length())
			return "";
		Map<Character, Integer> map = new HashMap<>();
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int count = 0;
		int left = 0;
		int minLeft = 0;
		int min = s.length() + 1;
		for (int right = 0; right < s.length(); right++) {
			char curR = s.charAt(right);
			if (map.containsKey(curR)) {
				map.put(curR, map.get(curR) - 1);
				if (map.get(curR) >= 0) {
					count++;
				}
			}
			while (count == t.length()) {
				int len = right - left + 1;
				if (len < min) {
					min = len;
					minLeft = left;
				}
				char curL = s.charAt(left);
				if (map.containsKey(curL)) {
					map.put(curL, map.get(curL) + 1);
					if (map.get(curL) > 0) {
						count--;
					}
				}
				left++;
			}
		}
		if (min > s.length())
			return "";
		return s.substring(minLeft, minLeft + min);

	}

}

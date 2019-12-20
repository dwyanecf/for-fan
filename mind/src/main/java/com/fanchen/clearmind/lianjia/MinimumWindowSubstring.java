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
		if (s == null || s.length() == 0 || t.length() > s.length())
			return "";
		Map<Character, Integer> map = new HashMap<>();
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int left = 0;
		int minLeft = 0;
		int minLenth = s.length() + 1;
		int count = 0;
		for (int right = 0; right < s.length(); right++) {
			char cur = s.charAt(right);
			if (map.containsKey(cur)) {
				map.put(cur, map.get(cur) - 1);
				if (map.get(cur) >= 0) {
					count++;
				}
			}
			while (count == s.length()) {
				int curLenth = right - left + 1;
				if (curLenth < minLenth) {
					minLenth = curLenth;
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
		if (minLenth > s.length())
			return "";
		return s.substring(minLeft, minLeft + minLenth);
	}

	/**
	 * if (s == null || s.length() == 0 || s.length() < t.length()) return "";
	 * Map<Character, Integer> map = new HashMap<>(); for (char c : t.toCharArray())
	 * { map.put(c, map.getOrDefault(c, 0) + 1); } int left = 0; int minLeft = 0;
	 * int minLen = s.length() + 1; int count = 0; for (int right = 0; right <
	 * s.length(); right++) { if (map.containsKey(s.charAt(right))) {
	 * map.put(s.charAt(right), map.get(s.charAt(right)) - 1); if
	 * (map.get(s.charAt(right)) >= 0) { count++; } while (count == t.length()) {
	 * int curLen = right - left +1; if (curLen < minLen) { minLeft = left; minLen =
	 * curLen; } if (map.containsKey(s.charAt(left))) { map.put(s.charAt(left),
	 * map.get(s.charAt(left)) + 1); if (map.get(s.charAt(left)) > 0) { count--; } }
	 * left++; } } } if (minLen > s.length()) { return ""; } return
	 * s.substring(minLeft, minLeft + minLen);
	 */
}

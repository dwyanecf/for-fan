package com.fanchen.clearmind.leetcode.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty word in str.
 * 
 * Examples: pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false. pattern =
 * "aaaa", str = "dog cat cat dog" should return false. pattern = "abba", str =
 * "dog dog dog dog" should return false. Notes: You may assume pattern contains
 * only lowercase letters, and str contains lowercase letters separated by a
 * single space.
 * 
 * Credits: Special thanks to @minglotus6 for adding this problem and creating
 * all test cases.
 * 
 * @author fan
 *
 */
public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
		if (pattern == null && str == null)
			return true;
		if (pattern == null || str == null)
			return false;

		Map<Character, String> map = new HashMap<>();
		String[] strs = str.split(" ");
		char[] cArray = pattern.toCharArray();
		if (cArray.length != strs.length)
			return false;
		for (int i = 0; i < cArray.length; i++) {
			if (map.containsKey(cArray[i]) && map.get(cArray[i]).equals(strs[i])) {
				return false;
			}
			map.put(cArray[i], strs[i]);
		}
		Set<String> set = new HashSet<>();
		for (Character c : map.keySet()) {
			if (!set.add(map.get(c))) {
				return false;
			}
		}
		return true;
	}
}

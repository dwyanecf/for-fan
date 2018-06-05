package com.fanchen.clearmind.leetcode.map.easy;

/**
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * 
 * Examples:
 * 
 * s = "leetcode" return 0.
 * 
 * s = "loveleetcode", return 2.
 * 
 * @author fan
 *
 */
public class FirstUniqueCharacterInString {
	public int firstUniqChar(String s) {
		int[] table = new int[256];
		char[] cArray = s.toCharArray();
		for (Character c : cArray) {
			table[c - 'a']++;
		}
		for (int i = 0; i < cArray.length; i++) {
			if (table[cArray[i] - 'a'] == 1) {
				return i;
			}
		}
		return -1;
	}
}

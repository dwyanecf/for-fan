package com.fanchen.clearmind.leetcode.map.easy;

/**
 * Given two strings s and t, write a function to determine if t is an anagram
 * of s.
 * 
 * For example, s = "anagram", t = "nagaram", return true. s = "rat", t = "car",
 * return false.
 * 
 * Note: You may assume the string contains only lowercase alphabets.
 * 
 * Follow up: What if the inputs contain unicode characters? How would you adapt
 * your solution to such case?
 * 
 * @author fan
 *
 */
public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if (s == null && t == null)
			return true;
		if (s.length() != t.length())
			return false;
		int[] table = new int[26];
		for (Character c : s.toCharArray()) {
			table[c - 'a']++;
		}
		for (Character c : t.toCharArray()) {
			table[c - 'a']--;
		}
		for (int i = 0; i < 26; i++) {
			if (table[i] != 0)
				return false;
		}
		return true;
	}
}

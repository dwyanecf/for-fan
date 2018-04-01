package com.fanchen.clearmind.leetcode.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given a string which consists of lowercase or uppercase letters, find the
 * length of the longest palindromes that can be built with those letters.
 * 
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * 
 * Note: Assume the length of given string will not exceed 1,010.
 * 
 * Example:
 * 
 * Input: "abccccdd"
 * 
 * Output: 7
 * 
 * Explanation: One longest palindrome that can be built is "dccaccd", whose
 * length is 7.
 * 
 * @author fan
 *
 */
public class LongestPalindrome {
	public int longestPalindrome(String s) {
		int res = 0;
		Map<Character, Integer> map = new HashMap<>();
		char[] cArray = s.toCharArray();
		for (Character c : cArray) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		boolean OddAppear = false;

		for (Character key : map.keySet()) {
			int num = map.get(key);
			if (num % 2 == 0) {
				res += num;
			}
			if (num > 1 && num % 2 == 1) {
				res = res + num - 1;
			}
			if (num % 2 == 1) {
				OddAppear = true;
			}
		}

		return OddAppear ? res + 1 : res;

	}
}

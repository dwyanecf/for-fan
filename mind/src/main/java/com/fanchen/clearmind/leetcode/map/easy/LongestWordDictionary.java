package com.fanchen.clearmind.leetcode.map.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a list of strings words representing an English Dictionary, find the
 * longest word in words that can be built one character at a time by other
 * words in words. If there is more than one possible answer, return the longest
 * word with the smallest lexicographical order.
 * 
 * If there is no answer, return the empty string. Example 1: Input: words =
 * ["w","wo","wor","worl", "world"] Output: "world" Explanation: The word
 * "world" can be built one character at a time by "w", "wo", "wor", and "worl".
 * Example 2: Input: words = ["a", "banana", "app", "appl", "ap", "apply",
 * "apple"] Output: "apple" Explanation: Both "apply" and "apple" can be built
 * from other words in the dictionary. However, "apple" is lexicographically
 * smaller than "apply".
 * 
 * @author fan
 *
 */
public class LongestWordDictionary {
	public String longestWord(String[] words) {
		String res = "";
		Set<String> set = new HashSet<>();
		Arrays.sort(words);

		for (String word : words) {
			if (word.length() == 1 || set.contains(word.substring(0, word.length() - 1))) {
				if (res.length() < word.length())
					res = word;
				set.add(word);
			}
		}
		return res;
	}
}

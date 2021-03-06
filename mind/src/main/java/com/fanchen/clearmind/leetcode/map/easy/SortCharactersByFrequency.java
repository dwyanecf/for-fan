package com.fanchen.clearmind.leetcode.map.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string, sort it in decreasing order based on the frequency of
 * characters.
 * 
 * Example 1:
 * 
 * Input: "tree"
 * 
 * Output: "eert"
 * 
 * Explanation: 'e' appears twice while 'r' and 't' both appear once. So 'e'
 * must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 * 
 * Input: "cccaaa"
 * 
 * Output: "cccaaa"
 * 
 * Explanation: Both 'c' and 'a' appear three times, so "aaaccc" is also a valid
 * answer. Note that "cacaca" is incorrect, as the same characters must be
 * together. Example 3:
 * 
 * Input: "Aabb"
 * 
 * Output: "bbAa"
 * 
 * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect. Note
 * that 'A' and 'a' are treated as two different characters.
 * 
 * @author fan
 *
 */
public class SortCharactersByFrequency {
	public String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (Character key : s.toCharArray()) {
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		@SuppressWarnings("unchecked")
		List<Character>[] frequency = new ArrayList[s.length() + 1];
		for (Character key : map.keySet()) {
			int freq = map.get(key);
			if (frequency[freq] == null) {
				frequency[freq] = new ArrayList<Character>();
			}
			frequency[freq].add(key);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = frequency.length - 1; i >= 0; i--) {
			if (frequency[i] != null) {
				for (Character c : frequency[i]) {
					for (int j = 0; j < i; j++) {
						sb.append(c);
					}
				}
			}
		}
		return sb.toString();
	}
}

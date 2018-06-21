package com.fanchen.clearmind.leetcode.map.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * Given a List of words, return the words that can be typed using letters of
 * alphabet on only one row's of American keyboard like the image below.
 * 
 * 
 * American keyboard
 * 
 * 
 * Example 1: Input: ["Hello", "Alaska", "Dad", "Peace"] Output: ["Alaska",
 * "Dad"] Note: You may use one character in the keyboard more than once. You
 * may assume the input string will only contain letters of alphabet.
 *
 */

public class Keyboard {
	public String[] findWords(String[] words) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String row1 = "qwertyuiop";
		String row2 = "asdfghjkl";
		String row3 = "zxcvbnm";
		for (Character r1 : row1.toCharArray()) {
			map.put(r1.toString(), 1);
		}
		for (Character r2 : row2.toCharArray()) {
			map.put(r2.toString(), 2);
		}
		for (Character r3 : row3.toCharArray()) {
			map.put(r3.toString(), 3);
		}
		List<String> list = new ArrayList<String>();
		for (String word : words) {
			char[] wArray = word.toCharArray();
			if (checkSameLevel(wArray, map)) {
				list.add(word);
			}
		}
		return list.toArray(new String[list.size()]);
	}

	private boolean checkSameLevel(char[] wArray, HashMap<String, Integer> map) {
		for (int i = 0; i < wArray.length - 1; i++) {
			if (map.get(String.valueOf(wArray[i]).toLowerCase()) != map
					.get(String.valueOf(wArray[i + 1]).toLowerCase())) {
				return false;
			}
		}
		return true;
	}

}

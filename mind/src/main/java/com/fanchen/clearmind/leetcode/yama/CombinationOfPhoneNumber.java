package com.fanchen.clearmind.leetcode.yama;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * @author Fan Chen
 *
 */
public class CombinationOfPhoneNumber {
	public List<String> letterCombinations(String digits) {
		List<String> list = new ArrayList<>();
		if (digits == null || digits.length() == 0)
			return list;
		String[][] table = { {}, {}, { "a", "b", "c" }, { "d", "e", "f" }, { "g", "h", "i" }, { "j", "k", "l" },
				{ "m", "n", "o" }, { "p", "q", "r", "s" }, { "t", "u", "v" }, { "w", "x", "y", "z" } };
		backTrack("", list, digits, table, 0);
		return list;
	}

	private void backTrack(String cur, List<String> list, String digits, String[][] table, int index) {
		if (index == digits.length()) {
			list.add(cur);
			return;
		}

		String[] book = table[digits.charAt(index) - '0'];
		for (int i = 0; i < book.length; i++) {
			cur = cur + book[i];
			backTrack(cur, list, digits, table, index + 1);
			cur = cur.substring(0, cur.length() - 1);
		}
	}
}

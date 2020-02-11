/*
 * Copyright (C) 2019 Copart, Inc. All rights reserved.
 */
package com.fanchen.groupsolve;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fan Chen
 *
 */
public class PalindromePartitioning {

	/*
	 * Return all possible palindrome partitioning of s.
	 * 
	 * Example:
	 * 
	 * Input: "aab" Output: [ ["aa","b"], ["a","a","b"] ]
	 */

	public List<List<String>> partition(String s) {
		List<List<String>> list = new ArrayList<>();
		backtrack(list, new ArrayList<>(), s, 0);
		return list;
	}

	public void backtrack(List<List<String>> list, List<String> cur, String s, int lo) {
		if (lo == s.length())
			list.add(new ArrayList<>(cur));
		else {
			for (int hi = lo; hi < s.length(); hi++) {
				if (isPalindrome(s, lo, hi)) {
					cur.add(s.substring(lo, hi + 1));
					backtrack(list, cur, s, hi + 1);
					cur.remove(cur.size() - 1);
				}
			}
		}
	}

	public boolean isPalindrome(String s, int lo, int hi) {
		while (lo < hi)
			if (s.charAt(lo++) != s.charAt(hi--))
				return false;
		return true;
	}
}

package com.fanchen.clearmind.leetcode.yama.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC140DFSBASIC {

	/**
	 * Input:
		s = "catsanddog"
		wordDict = ["cat", "cats", "and", "sand", "dog"]
		Output:
		[
		  "cats and dog",
		  "cat sand dog"
		]
	 */
	public static List<String> wordBreak(String s, List<String> wordDict) {
		return wordBreakHelper(s, wordDict);
	}

	public static List<String> wordBreakHelper(String s, List<String> wordDict) {
		List<String> results = new ArrayList<String>();
		// Base case
		if (s.length() == 0) {
			results.add("");
			return results;
		}
		// Break the string
		for (String word : wordDict) {
			if (s.startsWith(word)) {
				List<String> substrings = wordBreakHelper(s.substring(word.length()), wordDict);

				for (String sub : substrings) {
					String optionalSpace = sub.isEmpty() ? "" : " ";

					results.add(word + optionalSpace + sub);
				}
			}
		}
		return results;

	}
	
	public static void main(String[] args) {
		String s = "catsanddog";
		List<String> dict = Arrays.asList("cat", "cats", "and", "sand", "dog");
		wordBreak(s, dict);
	}
}

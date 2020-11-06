package com.fanchen.clearmind.leetcode.yama.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC140 {

	/**
	 * Input: s = "catsanddog" wordDict = ["cat", "cats", "and", "sand", "dog"]
	 * Output: [ "cats and dog", "cat sand dog" ]
	 * 
	 * @param s
	 * @param wordDict
	 * @return
	 */
	Map<String, List<String>> map;

	public List<String> wordBreak(String s, List<String> wordDict) {
		map = new HashMap<String, List<String>>();
		return wordBreakHelper(s, wordDict);
	}

	public List<String> wordBreakHelper(String s, List<String> wordDict) {
		List<String> results = new ArrayList<String>();
		if (map.containsKey(s))
			return map.get(s);
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
		map.put(s, results);
		return results;

	}
}

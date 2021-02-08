package com.fanchen.clearmind.indeed.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

	// word break 1
	public boolean wordBreak1(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 0; i < s.length(); i++) {
			for (String word : wordDict) {
				if (dp[i]) {
					if (s.startsWith(word, i)) {
						dp[i + word.length()] = true;
					}
				}
			}
		}
		return dp[s.length()];
	}

	// word break 2
	
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

	Map<String, List<String>> map;

	public List<String> wordBreak2(String s, List<String> wordDict) {
		map = new HashMap<>();
		return helper(s, wordDict);
	}

	public List<String> helper(String s, List<String> wordDict) {
		List<String> res = new ArrayList<>();
		if (map.containsKey(s)) {
			return map.get(s);
		}
		if (s.length() == 0) {
			res.add("");
			return res;
		}
		for (String word : wordDict) {
			if (s.startsWith(word)) {
				List<String> subList = helper(s.substring(word.length()), wordDict);
				for (String sub : subList) {
					String space = sub.isEmpty() ? "" : " ";
					res.add(word + space + sub);
				}
			}
		}
		map.put(s, res);
		return res;
	}
	
	
	public static void main(String[] args) {
		String s = "catsanddog";
		List<String> dict = Arrays.asList("cat","cats","and","sand","dog");
		WordBreak wb = new WordBreak();
		wb.wordBreak2(s, dict);
	}

}













































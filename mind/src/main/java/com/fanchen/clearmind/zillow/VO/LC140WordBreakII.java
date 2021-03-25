package com.fanchen.clearmind.zillow.VO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC140WordBreakII {
	public boolean wordBreak(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];
		// dp[i] represents whether s[0...i] can be formed by dict
		dp[0] = true;
		for (int i = 0; i < s.length(); i++) {
			if (dp[i]) {
				for (String word : wordDict) {
					if (s.startsWith(word, i)) {
						dp[i + word.length()] = true;
					}
				}
			}
		}
		return dp[s.length()];
	}

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
}

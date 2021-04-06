package com.fanchen.clearmind.zillow.VO;

import java.util.List;

public class LC139WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];
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
}

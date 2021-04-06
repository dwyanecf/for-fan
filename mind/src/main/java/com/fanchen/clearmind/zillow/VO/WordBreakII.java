package com.fanchen.clearmind.zillow.VO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakII {
	Map<String, List<String>> map;

	public List<String> wordBreak(String s, List<String> wordDict) {
		map = new HashMap<>();
		return helper(s, wordDict);
	}

	private List<String> helper(String s, List<String> wordDict) {
		if (map.containsKey(s)) {
			return map.get(s);
		}
		List<String> list = new ArrayList<>();
		if (s.length() == 0) {
			list.add("");
			return list;
		}

		for (String word : wordDict) {
			if (s.startsWith(word)) {
				List<String> subList = helper(s.substring(word.length()), wordDict);
				for (String str : subList) {
					String space = str.isEmpty() ? "" : " ";
					list.add(word + space + str);
				}
			}
		}
		map.put(s, list);
		return list;
	}
}

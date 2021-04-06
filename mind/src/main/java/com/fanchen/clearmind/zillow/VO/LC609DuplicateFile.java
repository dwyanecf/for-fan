package com.fanchen.clearmind.zillow.VO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC609DuplicateFile {
	public List<List<String>> findDuplicate(String[] paths) {
		Map<String, List<String>> map = new HashMap<>();
		for (String path : paths) {
			String[] tokens = path.split(" ");
			for (int i = 1; i < tokens.length; i++) {
				String fileName = tokens[i].substring(0, tokens[i].indexOf("("));
				String content = tokens[i].substring(tokens[i].indexOf("(") + 1, tokens[i].indexOf(")"));
				map.putIfAbsent(content, new ArrayList<String>());
				map.get(content).add(tokens[0] + "/" + fileName);
			}
		}
		List<List<String>> list = new ArrayList<>();
		for (List<String> value : map.values()) {
			if (value.size() > 1) {
				list.add(value);
			}
		}
		return list;
	}
}

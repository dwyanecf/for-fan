package com.fanchen.clearmind.leetcode.yama.vo;

import java.util.ArrayList;
import java.util.List;

public class LC722RemoveComments {
	public List<String> removeComments(String[] source) {
		List<String> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		boolean mode = false;
		for (String s : source) {
			for (int i = 0; i < s.length(); i++) {
				if (mode) {
					if (s.charAt(i) == '*' && i + 1 < s.length() && s.charAt(i + 1) == '/') {
						mode = false;
						i++;
					}
				} else {
					if (s.charAt(i) == '/' && i + 1 < s.length() && s.charAt(i + 1) == '/') {
						break;
					} else if (s.charAt(i) == '/' && i + 1 < s.length() && s.charAt(i + 1) == '*') {
						mode = true;
						i++;
					} else {
						sb.append(s.charAt(i));
					}
				}
			}
			if (!mode && sb.length() != 0) {
				list.add(sb.toString());
				sb.setLength(0);
			}
		}
		return list;
	}
}

package com.fanchen.clearmind.ebay;

public class LC14LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		StringBuilder sb = new StringBuilder(strs[0]);
		for (int i = 1; i < strs.length; i++) {
			while (strs[i].indexOf(sb.toString()) != 0) {
				sb.setLength(sb.length() - 1);
			}
		}
		return sb.toString();
	}
}

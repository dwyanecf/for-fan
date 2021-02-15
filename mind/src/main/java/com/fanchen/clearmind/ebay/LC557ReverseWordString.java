package com.fanchen.clearmind.ebay;

public class LC557ReverseWordString {
	public String reverseWords(String s) {

		if (s == null || s.length() == 0)
			return "";

		String[] children = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (String child : children) {
			sb.append(" ").append(revertString(child));
		}
		return sb.toString().trim();

	}

	private String revertString(String child) {

		if (child == null | child.length() == 0)
			return "";

		char[] s = child.toCharArray();
		int lo = 0;
		int hi = s.length - 1;
		while (lo < hi) {
			char temp = s[lo];
			s[lo++] = s[hi];
			s[hi--] = temp;

		}
		return new String(s);
	}
}

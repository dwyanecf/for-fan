package com.fanchen.clearmind.ebay;

public class LC344ReverseString {
	public void reverseString(char[] s) {
		if (s == null || s.length == 0)
			return;
		int lo = 0;
		int hi = s.length - 1;
		while (lo < hi) {
			char temp = s[lo];
			s[lo++] = s[hi];
			s[hi--] = temp;
		}
	}
}

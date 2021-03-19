package com.fanchen.clearmind.zillow.dianmian;

public class LC647PalindromicSubstrings {

	public int countSubstrings(String s) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			res += helper(s, i, i) + helper(s, i, i + 1);
		}
		return res;
	}

	public int helper(String s, int lo, int hi) {
		int count = 0;
		while (lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
			lo--;
			hi++;
			count++;
		}
		return count;
	}
}

package com.fanchen.clearmind.zillow.VO;

public class LC647PalundromicSubstrings {
	public int countSubstrings(String s) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			res += helper(i, i, s) + helper(i, i + 1, s);
		}
		return res;
	}

	public int helper(int lo, int hi, String s) {
		int count = 0;
		while (lo >= 0 && hi <= s.length() && s.charAt(lo) == s.charAt(hi)) {
			count++;
			lo--;
			hi++;
		}
		return count;
	}
}

package com.fanchen.clearmind.zillow.VO;

public class LC340LongestSubstringKDistinct {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		int res = 0;
		int lo = 0;
		int hi = 0;
		int count = 0;
		int[] table = new int[256];
		while (hi < s.length()) {
			if (table[s.charAt(hi)]++ == 0) {
				count++;
			}
			if (count > k) {
				while (--table[s.charAt(lo++)] > 0)
					;
				count--;
			}
			res = Math.max(res, hi - lo + 1);
			hi++;
		}
		return res;
	}
}

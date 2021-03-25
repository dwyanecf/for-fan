package com.fanchen.clearmind.zillow.VO;

import java.util.Arrays;

public class LCPermutationInString {
	public boolean checkInclusion(String s1, String s2) {
		int n1 = s1.length();
		int n2 = s2.length();
		int[] freq1 = new int[26];
		int[] freq2 = new int[26];
		for (char c : s1.toCharArray()) {
			freq1[c - 'a']++;
		}
		for (int i = 0; i < n2; i++) {
			freq2[s2.charAt(i) - 'a']++;
			if (i >= n1) {
				freq2[s2.charAt(i - n1) - 'a']--;
			}
			if (Arrays.equals(freq1, freq2)) {
				return true;
			}
		}
		return false;
	}
}

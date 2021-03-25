package com.fanchen.clearmind.zillow.VO;

public class LC387FirstUniqueCharacter {
	public int firstUniqChar(String s) {
		int[] table = new int[26];
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			table[c[i] - 'a']++;
		}
		for (int i = 0; i < c.length; i++) {
			if (table[c[i] - 'a'] == 1) {
				return i;
			}
		}
		return -1;
	}
}

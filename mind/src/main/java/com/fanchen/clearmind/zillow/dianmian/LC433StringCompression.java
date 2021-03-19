package com.fanchen.clearmind.zillow.dianmian;

public class LC433StringCompression {
	public static int compress(char[] chars) {
		int i = 0;
		int index = 0;
		while (i < chars.length) {
			int count = 0;
			char cur = chars[i];
			while (i < chars.length && chars[i] == cur) {
				count++;
				i++;
			}
			chars[index++] = cur;
			if (count != 1) {
				for (char c : String.valueOf(count).toCharArray()) {
					chars[index++] = c;
				}
			}
		}
		for (int j = index; j < chars.length; j++) {
			chars[j] = ' ';
		}
		for (char c : chars)
			System.out.println(c);
		return index;
	}

	public static void main(String[] args) {
		char[] c = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
		compress(c);
	}
}

package com.fanchen.groupsolve;

public class LongestUniformSubstring {

	public static String longestUniformSubString(String s) {
		if (s == null || s.length() <= 1)
			return s;

		int max = 1;
		int curMax = 1;
		char pre = s.charAt(0);
		int preIndex = 0;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == pre) {
				curMax++;
				if (max < curMax) {
					max = curMax;
					preIndex = i - max + 1;
				}
			} else {
				pre = s.charAt(i);
				curMax = 1;
			}
		}
		return s.substring(preIndex, preIndex + max);
	}

	public static void main(String[] args) {
		System.out.println(
				longestUniformSubString("moplvidmaamqscmxrxrvwsnjjvygrelcbjgbpounhuyealllginkitfgatlsxfhpcidfgzrc"));
	}
}

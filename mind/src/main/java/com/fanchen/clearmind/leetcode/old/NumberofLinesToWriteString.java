package com.fanchen.clearmind.leetcode.old;

/**
 * 
 * We are to write the letters of a given string S, from left to right into
 * lines. Each line has maximum width 100 units, and if writing a letter would
 * cause the width of the line to exceed 100 units, it is written on the next
 * line. We are given an array widths, an array where widths[0] is the width of
 * 'a', widths[1] is the width of 'b', ..., and widths[25] is the width of 'z'.
 * 
 * Now answer two questions: how many lines have at least one character from S,
 * and what is the width used by the last such line? Return your answer as an
 * integer list of length 2.
 *
 */
public class NumberofLinesToWriteString {
	public int[] numberOfLines(int[] widths, String S) {
		if (S == null || S.isEmpty())
			return new int[2];
		int lines = 1;
		int unit = 100;
		char[] charArray = S.toCharArray();
		for (Character c : charArray) {
			if (unit - widths[c - 'a'] < 0) {
				unit = 100;
				lines++;
			}
			unit -= widths[c - 'a'];
		}

		int[] res = new int[2];
		res[0] = lines;
		res[1] = 100 - unit;
		return res;
	}
}

package com.fanchen.clearmind.zillow.VO;

import java.util.ArrayList;
import java.util.List;

public class LC301RemoveInvalidParentheses {
	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<>();
		helper(s, res, 0, 0, new char[] { '(', ')' });
		return res;
	}

	private void helper(String s, List<String> res, int i_start, int j_start, char[] cs) {
		int open = 0;
		int close = 0;
		for (int i = i_start; i < s.length(); i++) {
			if (s.charAt(i) == cs[0]) {
				open++;
			} else if (s.charAt(i) == cs[1]) {
				close++;
			}
			if (close > open) {
				for (int j = j_start; j <= i; j++) {
					if (s.charAt(j) == cs[1] && (j == j_start || s.charAt(j - 1) != cs[1])) {
						helper(s.substring(0, j) + s.substring(j + 1, s.length()), res, i, j, cs);
					}
				}
				return;
			}
		}
		// No invalid closed parenthesis detected. Now check opposite direction, or
		// reverse back to original direction.
		String reversedStr = new StringBuilder(s).reverse().toString();
		if (cs[0] == '(') {
			helper(reversedStr, res, 0, 0, new char[] { ')', '(' });
		} else {
			res.add(reversedStr);
		}
	}
}

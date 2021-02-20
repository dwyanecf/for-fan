package com.fanchen.clearmind.ebay.medium;

import java.util.ArrayList;
import java.util.List;

public class LC22GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<>();
		helper(list, "", 0, 0, n);
		return list;
	}

	public void helper(List<String> list, String cur, int open, int close, int max) {
		if (cur.length() == 2 * max) {
			list.add(cur);
			return;
		}
		if (open < max) {
			helper(list, cur + "(", open + 1, close, max);
		}
		if (close < open) {
			helper(list, cur + ")", open, close + 1, max);
		}
	}

	public static void main(String[] args) {
		LC22GenerateParentheses sb = new LC22GenerateParentheses();
		sb.generateParenthesis(3);
	}
}

package com.fanchen.clearmind.lianjia;

import java.util.ArrayList;
import java.util.List;

/**
 * Remove the minimum number of invalid parentheses in order to make the input
 * string valid. Return all possible results.
 *
 * Note: The input string may contain letters other than the parentheses ( and
 * ).
 *
 * Example 1:
 *
 * Input: "()())()" Output: ["()()()", "(())()"] Example 2:
 *
 * Input: "(a)())()" Output: ["(a)()()", "(a())()"] Example 3:
 *
 * Input: ")(" Output: [""]
 */
public class RemoveInvalidParentheses {

	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<>();
		helper(res, s, 0, 0, new char[] { '(', ')' });
		return res;
	}

	/**
	 * @param res
	 * @param s
	 * @param i
	 * @param j
	 * @param cs
	 */
	private void helper(List<String> res, String s, int last_i, int last_j, char[] cs) {
		int count = 0;
		for (int i = last_i; i < s.length(); i++) {
			if (s.charAt(i) == cs[0])
				count++;
			if (s.charAt(i) == cs[1])
				count--;
			if (count >= 0)
				continue;

			for (int j = last_j; j <= i; j++) {
				if (s.charAt(j) == cs[1] && (j == last_j || s.charAt(j - 1) != cs[1])) {
					helper(res, s.substring(0, j) + s.substring(j + 1, s.length()), i, j, cs);
				}
			}
			return;

		}
		String reversed = new StringBuilder(s).reverse().toString();
		if (cs[0] == '(') {
			helper(res, reversed, 0, 0, new char[] { ')', '(' });
		} else {
			res.add(reversed);
		}

	}
}

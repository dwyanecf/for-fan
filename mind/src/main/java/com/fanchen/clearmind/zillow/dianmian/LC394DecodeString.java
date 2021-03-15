package com.fanchen.clearmind.zillow.dianmian;

import java.util.Stack;

/**
 * Input: s = "3[a]2[bc]" Output: "aaabcbc" Input: s = "2[abc]3[cd]ef" Output:
 * "abcabccdcdcdef"
 * 
 * @author fachen
 *
 */
public class LC394DecodeString {
	public String decodeString(String s) {
		Stack<Integer> numberStack = new Stack<>();
		Stack<StringBuilder> stringStack = new Stack<>();
		int k = 0;
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				k = k * 10 + c - '0';
			} else if (c == '[') {
				numberStack.push(k);
				stringStack.push(sb);
				sb = new StringBuilder();
				k = 0;
			} else if (c == ']') {
				StringBuilder temp = sb;
				sb = stringStack.pop();
				k = numberStack.pop();
				while (k > 0) {
					sb.append(temp);
					k--;
				}
			} else {
				sb.append(c);
			}
		}

		return sb.toString();

	}
}

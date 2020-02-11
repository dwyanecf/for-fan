/*
 * Copyright (C) 2019 Copart, Inc. All rights reserved.
 */
package com.fanchen.groupsolve;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author fachen
 *
 */
public class DecodeWays {

	/**
	 * A message containing letters from A-Z is being encoded to numbers using the
	 * following mapping:
	 * 
	 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given a non-empty string containing only
	 * digits, determine the total number of ways to decode it.
	 * 
	 * Example 1:
	 * 
	 * Input: "12" Output: 2 Explanation: It could be decoded as "AB" (1 2) or "L"
	 * (12). Example 2:
	 * 
	 * Input: "226" Output: 3 Explanation: It could be decoded as "BZ" (2 26), "VF"
	 * (22 6), or "BBF" (2 2 6).
	 * 
	 * @param s
	 * @return
	 */
	public static List<String> decode(String s) {
		List<String> result = new ArrayList<String>();
		helper("", s, result);
		System.out.println(result);
		return result;
	}

	public static void helper(String prefix, String s, List<String> result) {

		int len = s.length();
		if (len == 0) {
			result.add(prefix);
			return;
		}
		if (s.charAt(0) == '0')
			return;

		helper(prefix + (char) (s.charAt(0) - '1' + 'a'), s.substring(1), result);

		if (len >= 2) {
			int value = Integer.parseInt(s.substring(0, 2));
			if (value <= 26)
				helper(prefix + (char) (value - 1 + 'a'), s.substring(2), result);
		}
	}


	public static void main(String[] args) {
		decode("226");
	}
}

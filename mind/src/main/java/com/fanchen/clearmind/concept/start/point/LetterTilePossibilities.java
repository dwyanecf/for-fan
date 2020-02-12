/*
 * Copyright (C) 2019 Copart, Inc. All rights reserved.
 */
package com.fanchen.clearmind.concept.start.point;

/**
 * @author Fan Chen You have a set of tiles, where each tile has one letter
 *         tiles[i] printed on it. Return the number of possible non-empty
 *         sequences of letters you can make.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: "AAB" Output: 8 Explanation: The possible sequences are "A",
 *         "B", "AA", "AB", "BA", "AAB", "ABA", "BAA". Example 2:
 * 
 *         Input: "AAABBC" Output: 188
 * 
 * 
 *         Note:
 * 
 *         1 <= tiles.length <= 7 tiles consists of uppercase English letters.
 * 
 */
public class LetterTilePossibilities {
	public int numTilePossibilities(String tiles) {
		int[] table = new int[26];
		for (char c : tiles.toCharArray()) {
			table[c - 'A']++;
		}
		return recursion(table);

	}

	/**
	 * @param table
	 * @return
	 */
	private int recursion(int[] table) {
		int sum = 0;
		for (int i = 0; i < 26; i++) {
			if (table[i] == 0)
				continue;
			sum++;
			table[i]--;
			sum += recursion(table);
			table[i]++;
		}
		return sum;
	}
}

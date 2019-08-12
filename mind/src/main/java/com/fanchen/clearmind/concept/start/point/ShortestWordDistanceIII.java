/*
 * Copyright (C) 2019 Copart, Inc. All rights reserved.
 */
package com.fanchen.clearmind.concept.start.point;

/**
 * @author fachen
 *
 */

/*
 * Given a list of words and two words word1 and word2, return the shortest
 * distance between these two words in the list.
 * 
 * word1 and word2 may be the same and they represent two individual words in
 * the list.
 */
public class ShortestWordDistanceIII {
	public int shortestWordDistance(String[] words, String word1, String word2) {
		boolean same = word1.equals(word2);
		int n = words.length;
		int l1 = n;
		int l2 = -n;
		int ans = l1 - l2;
		for (int i = 0; i < n; i++) {
			if (word1.equals(words[i])) {
				if (same) {
					l1 = l2;
					l2 = i;
				} else {
					l1 = i;
				}
			} else if (word2.equals(words[i])) {
				l2 = i;
			}
			ans = Math.min(ans, Math.abs(l2 - l1));
		}
		return ans;
	}
}

package com.fanchen.clearmind.indeed.vo;

public class LC243ShortestWordDistance {

	/**
	 * Example: Assume that words = ["practice", "makes", "perfect", "coding",
	 * "makes"].
	 * 
	 * Input: word1 = “coding”, word2 = “practice” Output: 3 Input: word1 = "makes",
	 * word2 = "coding" Output: 1
	 * 
	 * @param words
	 * @param word1
	 * @param word2
	 * @return
	 */
	public int shortestDistance(String[] words, String word1, String word2) {
		int n = words.length;
		int lo = -n;
		int hi = n;
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (words[i].equalsIgnoreCase(word1)) {
				lo = i;
				if (Math.abs(lo - hi) < res) {
					res = Math.abs(lo - hi);
				}
			} else if (words[i].equalsIgnoreCase(word2)) {
				hi = i;
				if (Math.abs(lo - hi) < res) {
					res = Math.abs(lo - hi);
				}
			}
		}
		return res != Integer.MAX_VALUE ? res : -1;
	}
}

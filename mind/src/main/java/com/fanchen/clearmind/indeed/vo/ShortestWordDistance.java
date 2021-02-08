package com.fanchen.clearmind.indeed.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistance {

	/**
	 * 
	 * https://leetcode.com/problems/shortest-word-distance/
	 * https://leetcode.com/problems/shortest-word-distance-ii/
	 * https://leetcode.com/problems/shortest-word-distance-iii/
	 * 
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
	public int shortestDistance1(String[] words, String word1, String word2) {

		int p1 = -1;
		int p2 = -1;
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				p1 = i;
			} else if (words[i].equals(word2)) {
				p2 = i;
			}

			if (p1 != -1 && p2 != -1) {
				res = Math.min(res, Math.abs(p1 - p2));
			}
		}
		return res != Integer.MAX_VALUE ? res : -1;

	}

	/**
	 * Word distance 2
	 */
	Map<String, List<Integer>> map = new HashMap<>();

	public ShortestWordDistance(String[] words) {
		for (int i = 0; i < words.length; i++) {
			String w = words[i];
			if (map.containsKey(w)) {
				map.get(w).add(i);
			} else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(w, list);
			}
		}
	}

	public int shortest2(String word1, String word2) {
		List<Integer> l1 = map.get(word1);
		List<Integer> l2 = map.get(word2);
		int res = Integer.MAX_VALUE;
		if (l1 == null || l2 == null)
			return res;

		int p1 = 0, p2 = 0;
		while (p1 < l1.size() && p2 < l2.size()) {
			int temp = Math.abs(l1.get(p1) - l2.get(p2));
			res = Math.min(res, temp);
			if (l1.get(p1) < l2.get(p2)) {
				p1++;
			} else {
				p2++;
			}
		}
		return res;
	}

	/**
	 * Shortest word distance 3
	 */
	public int shortestWordDistance3(String[] words, String word1, String word2) {

		boolean same = word1.equals(word2);
		int n = words.length;
		int p1 = n;
		int p2 = -n;
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (word1.equals(words[i])) {
				if (same) {
					p1 = p2;
					p2 = i;
				} else {
					p1 = i;
				}
			} else if (word2.equals(words[i])) {
				p2 = i;
			}
			ans = Math.min(ans, Math.abs(p2 - p1));
		}
		return ans;

	}

}













































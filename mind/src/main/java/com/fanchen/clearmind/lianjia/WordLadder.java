package com.fanchen.clearmind.lianjia;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 *
 * Only one letter can be changed at a time. Each transformed word must exist in
 * the word list. Note that beginWord is not a transformed word. Note:
 *
 * Return 0 if there is no such transformation sequence. All words have the same
 * length. All words contain only lowercase alphabetic characters. You may
 * assume no duplicates in the word list. You may assume beginWord and endWord
 * are non-empty and are not the same. Example 1:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList =
 * ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" ->
 * "dog" -> "cog", return its length 5. Example 2:
 *
 * Input: beginWord = "hit" endWord = "cog" wordList =
 * ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible
 * transformation.
 */
public class WordLadder {
	public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
		Set<String> dict = new HashSet<>(wordList);
		Set<String> visited = new HashSet<>();
		Queue<String> q = new LinkedList<>();
		q.offer(beginWord);
		for (int time = 1; !q.isEmpty(); time++) {
			for (int i = q.size(); i > 0; i--) {
				String s = q.poll();
				if (s.equals(endWord))
					return time;
				for (int index = 0; index < s.length(); index++) {
					char[] cur = s.toCharArray();
					for (char c = 'a'; c <= 'z'; c++) {
						if (cur[index] == c)
							continue;
						cur[index] = c;
						String str = String.valueOf(cur);
						if (visited.add(str) && dict.contains(str)) {
							q.offer(str);
						}
					}
				}
			}
		}
		return 0;
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> dict = new HashSet<>(wordList);
		if (!dict.contains(endWord))
			return 0;
		Set<String> set1 = new HashSet<>();
		Set<String> set2 = new HashSet<>();
		set1.add(beginWord);
		set2.add(endWord);
		return helper(dict, set1, set2, 1);
	}

	int helper(Set<String> dict, Set<String> set1, Set<String> set2, int level) {
		if (set1.isEmpty())
			return 0;
		if (set1.size() > set2.size())
			return helper(dict, set2, set1, level);
		for (String key1 : set1) {
			dict.remove(key1);
		}
		for (String key2 : set2) {
			dict.remove(key2);
		}
		Set<String> set3 = new HashSet<>();
		for (String key : set1) {
			for (int i = 0; i < key.length(); i++) {
				char[] cStr = key.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					cStr[i] = c;
					String cur = new String(cStr);
					if (set2.contains(cur)) {
						return level + 1;
					}
					if (dict.contains(cur)) {
						set3.add(cur);
					}
				}
			}
		}
		return helper(dict, set3, set2, level + 1);
	}
}

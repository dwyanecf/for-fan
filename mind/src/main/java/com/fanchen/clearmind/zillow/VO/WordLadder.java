package com.fanchen.clearmind.zillow.VO;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	/**
	 * Queue
	 * 
	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 */
	public int ladderLengthQueue(String beginWord, String endWord, List<String> wordList) {
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

	/**
	 * 2 set
	 * 
	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 */
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

	public int helper(Set<String> dict, Set<String> set1, Set<String> set2, int level) {
		if (set1.isEmpty())
			return 0;
		if (set1.size() > set2.size()) {
			return helper(dict, set2, set1, level);
		}
		dict.removeAll(set1);
		dict.removeAll(set2);
		Set<String> temp = new HashSet<>();
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
						temp.add(cur);
					}
				}
			}
		}
		return helper(dict, set2, temp, level + 1);
	}
}

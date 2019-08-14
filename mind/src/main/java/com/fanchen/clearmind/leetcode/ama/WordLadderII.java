package com.fanchen.clearmind.leetcode.ama;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadderII {

	/**
	 * Given two words (beginWord and endWord), and a dictionary's word list, find
	 * all shortest transformation sequence(s) from beginWord to endWord, such that:
	 * 
	 * Only one letter can be changed at a time Each transformed word must exist in
	 * the word list. Note that beginWord is not a transformed word. Note:
	 * 
	 * Return an empty list if there is no such transformation sequence. All words
	 * have the same length. All words contain only lowercase alphabetic characters.
	 * You may assume no duplicates in the word list. You may assume beginWord and
	 * endWord are non-empty and are not the same. Example 1:
	 * 
	 * Input: beginWord = "hit", endWord = "cog", wordList =
	 * ["hot","dot","dog","lot","log","cog"]
	 * 
	 * Output: [ ["hit","hot","dot","dog","cog"], ["hit","hot","lot","log","cog"] ]
	 * Example 2:
	 * 
	 * Input: beginWord = "hit" endWord = "cog" wordList =
	 * ["hot","dot","dog","lot","log"]
	 * 
	 * Output: []
	 * 
	 * Explanation: The endWord "cog" is not in wordList, therefore no possible
	 * transformation.
	 */

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> list = new ArrayList<>();
		Set<String> dict = new HashSet<>(wordList);
		if (!dict.contains(endWord))
			return list;
		Set<String> set1 = new HashSet<>();
		Set<String> set2 = new HashSet<>();
		set1.add(beginWord);
		set2.add(endWord);
		Map<String, Set<String>> map = new HashMap<>();
		boolean find = false;
		boolean reverse = false;

		while (!find && !set1.isEmpty()) {
			Set<String> temp = new HashSet<>();
			if (set1.size() < set2.size()) {
				Set<String> tmp = set1;
				set1 = set2;
				set2 = tmp;
				reverse = !reverse;
			}
			dict.removeAll(set1);
			for (String key : set1) {
				for (int i = 0; i < key.length(); i++) {
					char[] cStr = key.toCharArray();
					for (char c = 'a'; c <= 'z'; c++) {
						cStr[i] = c;
						String cur = new String(cStr);
						if (set2.contains(cur)) {
							find = true;
						}
						if (dict.contains(cur)) {
							String originWord = reverse ? cur : key;
							String transformedWord = reverse ? key : cur;
							if (!map.containsKey(originWord)) {
								map.put(originWord, new HashSet<>());
							}
							map.get(originWord).add(transformedWord);
							temp.add(cur);
						}
					}
				}
			}
			set1 = temp;
		}
		if (!find)
			return list;
		List<String> tempList = new ArrayList<>();
		tempList.add(beginWord);
		backTrack(dict, tempList, beginWord, endWord, map, list);
		return list;

	}

	private void backTrack(Set<String> dict, List<String> tempList, String beginWord, String endWord,
			Map<String, Set<String>> map, List<List<String>> list) {
		// TODO Auto-generated method stub
		if (beginWord.equals(endWord)) {
			list.add(new ArrayList<>(tempList));
		} else if (map.containsKey(beginWord)) {
			for (String word : map.get(beginWord)) {
				tempList.add(word);
				backTrack(dict, tempList, word, endWord, map, list);
				tempList.remove(tempList.size() - 1);
			}
		}

	}
}

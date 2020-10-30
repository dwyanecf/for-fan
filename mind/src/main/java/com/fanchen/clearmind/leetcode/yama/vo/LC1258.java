package com.fanchen.clearmind.leetcode.yama.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LC1258 {
	/**
	 * Give you a list of synonymssynonyms And a sentencetext ， synonyms There are
	 * some pairs of synonyms in the table, you can put the sentencetext Each word
	 * in is replaced by its synonyms.
	 * 
	 * Please find all the sentences that have been replaced by synonyms,
	 * pressLexicographic sort Then return.
	 * 
	 * 
	 * Example: Enter: synonyms =
	 * [["happy","joy"],["sad","sorrow"],["joy","cheerful"]], text = "I am happy
	 * today but was sad yesterday" Output: ["I am cheerful today but was sad
	 * yesterday", "I am cheerful today but was sorrow yesterday", "I am happy today
	 * but was sad yesterday", "I am happy today but was sorrow yesterday", "I am
	 * joy today but was sad yesterday", "I am joy today but was sorrow yesterday"]
	 */

	/**
	 * Constraints:
	 * 
	 * 0 <= synonyms.length <= 10 synonyms[i].length == 2 synonyms[i][0] !=
	 * synonyms[i][1] All words consist of at most 10 English letters only. text is
	 * a single space separated sentence of at most 10 words.
	 * 
	 * @author fachen
	 *
	 */

	Map<String, Set<String>> map = new HashMap<>();

	public List<String> generateSentences(List<List<String>> synonyms, String text) {
		// build graph.
		for (List<String> s : synonyms) {
			String a = s.get(0);
			String b = s.get(1);
			if (!map.containsKey(a)) {
				map.put(a, new HashSet<>());
			}
			if (!map.containsKey(b)) {
				map.put(b, new HashSet<>());
			}
			map.get(a).add(b);
			map.get(b).add(a);
		}
		String[] split = text.split("\\W+");
		List<String> res = new ArrayList<>();
		helper(res, split, 0, "");
		Collections.sort(res);
		for (String s : res) {
			System.out.println(s);
		}
		return res;
	}

	public void helper(List<String> res, String[] split, int index, String buildingString) {
		if (index == split.length) {
			res.add(buildingString.trim());
			return;
		}
		if (map.containsKey(split[index])) {
			List<String> choices = new ArrayList<>();
			// find all synonyms related to s
			dfs(split[index], new HashSet<>(), choices);
			// try to change word at index to every possible synonyms word
			for (String s : choices) {
				helper(res, split, index + 1, buildingString + " " + s);
			}
		} else {
			// if the word at index has no synonyms, just go for next.
			helper(res, split, index + 1, buildingString + " " + split[index]);
		}
	}

	// get all synonyms related to s
	public void dfs(String s, Set<String> visited, List<String> choices) {
		choices.add(s);
		visited.add(s);
		for (String next : map.get(s)) {
			if (!visited.contains(next)) {
				dfs(next, visited, choices);
			}
		}
	}

	public static void main(String[] args) {
		LC1258 so = new LC1258();
		List<List<String>> synonyms = new ArrayList<>();
		List<String> list1 = Arrays.asList("happy", "joy");
		List<String> list2 = Arrays.asList("sad", "sorrow");
		List<String> list3 = Arrays.asList("joy", "cheerful");
		synonyms.add(list1);
		synonyms.add(list2);
		synonyms.add(list3);
		String text = "I am happy today but was sad yesterday";
		so.generateSentences(synonyms, text);

	}

}

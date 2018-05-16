package com.fanchen.clearmind.leetcode.tree;

import java.util.List;

/**
 * In English, we have a concept called root, which can be followed by some
 * other words to form another longer word - let's call this word successor. For
 * example, the root an, followed by other, which can form another word another.
 * 
 * Now, given a dictionary consisting of many roots and a sentence. You need to
 * replace all the successor in the sentence with the root forming it. If a
 * successor has many roots can form it, replace it with the root with the
 * shortest length.
 * 
 * You need to output the sentence after the replacement.
 * 
 * Example 1: Input: dict = ["cat", "bat", "rat"] sentence = "the cattle was
 * rattled by the battery" Output: "the cat was rat by the bat" Note: The input
 * will only have lower-case letters. 1 <= dict words number <= 1000 1 <=
 * sentence words number <= 1000 1 <= root length <= 100 1 <= sentence words
 * length <= 1000
 * 
 * @author fan
 *
 */
public class ReplaceWords2 {

	public String replaceWords(List<String> dict, String sentence) {
		TrieNode root = new TrieNode();
		for (String word : dict) {
			root.addWord(word, 0);
		}
		StringBuilder sb = new StringBuilder();
		String[] words = sentence.split(" ");
		for (String word : words) {
			sb.append(" ");
			sb.append(root.searchWord(word));
		}
		return sb.toString().trim();
	}

	public class TrieNode {
		TrieNode[] list = new TrieNode[26];
		boolean isLeaf = false;

		public void addWord(String word, int i) {
			TrieNode next = null;
			int index = word.charAt(i) - 'a';
			if (list[index] == null) {
				list[index] = new TrieNode();
			}
			next = list[index];
			if (i + 1 == word.length()) {
				next.isLeaf = true;
			} else {
				next.addWord(word, i + 1);
			}
		}

		public String searchWord(String word) {
			StringBuilder sb = new StringBuilder();
			TrieNode cur = this;
			int i = 0;
			while (i < word.length()) {
				int index = word.charAt(i) - 'a';
				if (cur.list[index] != null) {
					sb.append(word.charAt(i));
					cur = cur.list[index];
					if (cur.isLeaf)
						return sb.toString();
					i++;
				} else {
					break;
				}
			}
			return word;
		}

	}

}

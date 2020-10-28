package com.fanchen.clearmind.leetcode.yama.vo;

import java.util.ArrayList;
import java.util.List;

public class LC472ConcateWords {
	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		List<String> result = new ArrayList<>();
		Trie root = new Trie();
		// Insert each word
		for (String word : words) {
			if (word.length() == 0)
				continue;
			Trie node = root;
			for (char c : word.toCharArray()) {
				if (node.next[c - 'a'] == null)
					node.next[c - 'a'] = new Trie();
				node = node.next[c - 'a'];
			}
			node.word = word;
		}
		for (String word : words)
			if (search(word, 0, root, root))
				result.add(word);

		return result;
	}

	private boolean search(String word, int index, Trie node, Trie root) {
		// tricky : the last word of the concatenated word is definitely storing the
		// last word
		if (index == word.length())
			return node.word != null && !node.word.equals(word);

		Trie current = node.next[word.charAt(index) - 'a'];

		if (current == null)
			return false;

		// only time when you found word and the search for the rest of the words are
		// true which is searched from the root
		if (current.word != null && search(word, index + 1, root, root))
			return true;

		// Keep moving with the next index
		return search(word, index + 1, current, root);
	}

	class Trie {
		Trie[] next = new Trie[26];
		String word;
	}
}

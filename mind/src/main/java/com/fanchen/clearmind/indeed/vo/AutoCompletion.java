package com.fanchen.clearmind.indeed.vo;

import java.util.ArrayList;
import java.util.List;

public class AutoCompletion {

	class TrieNode {
		boolean isWord;
		TrieNode[] children;

		public TrieNode() {
			this.isWord = false;
			this.children = new TrieNode[26];
		}

		public void insert(String word, int i) {
			if (i == word.length()) {
				isWord = true;
				return;
			}
			int pos = word.charAt(i) - 'a';
			if (children[pos] == null) {
				children[pos] = new TrieNode();
			}
			children[pos].insert(word, i + 1);
		}

		public TrieNode find(String prefix, int index) {
			if (index == prefix.length()) {
				return this;
			}
			int pos = prefix.charAt(index) - 'a';
			if (children[pos] == null) {
				return null;
			}
			return children[pos].find(prefix, index + 1);
		}
	}

	TrieNode root;

	public AutoCompletion(List<String> words) {
		this.root = new TrieNode();
		for (String word : words) {
			root.insert(word, 0);
		}
	}

	public List<String> find(String prefix) {
		List<String> res = new ArrayList<>();
		TrieNode cur = root;
		TrieNode pRoot = cur.find(prefix, 0);
		helper(res, pRoot, prefix);
		return res;
	}

	public void helper(List<String> res, TrieNode pRoot, String curS) {
		if (pRoot == null) {
			return;
		}
		if (pRoot.isWord) {
			res.add(curS);
		}

		String tempS = curS;
		for (int i = 0; i < 26; i++) {
			char c = (char) ('a' + i);
			helper(res, pRoot.children[i], tempS + c);
		}
	}

	public static void main(String[] args) {

		List<String> words = new ArrayList<>();
		words.add("ab");
		words.add("a");
		words.add("de");
		words.add("abde");

		AutoCompletion test = new AutoCompletion(words);
		String prefix = "ab";
		List<String> res = test.find(prefix);
		System.out.println(res);
	}

}

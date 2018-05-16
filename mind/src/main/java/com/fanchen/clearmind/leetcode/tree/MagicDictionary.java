package com.fanchen.clearmind.leetcode.tree;

/**
 * Implement a magic directory with buildDict, and search methods.
 * 
 * For the method buildDict, you'll be given a list of non-repetitive words to
 * build a dictionary.
 * 
 * For the method search, you'll be given a word, and judge whether if you
 * modify exactly one character into another character in this word, the
 * modified word is in the dictionary you just built.
 * 
 * Example 1:
 * 
 * Input: buildDict(["hello", "leetcode"]), Output: Null Input: search("hello"),
 * Output: False Input: search("hhllo"), Output: True Input: search("hell"),
 * Output: False Input: search("leetcoded"), Output: False
 * 
 * Note:
 * 
 * You may assume that all the inputs are consist of lowercase letters a-z. For
 * contest purpose, the test data is rather small by now. You could think about
 * highly efficient algorithm after the contest. Please remember to RESET your
 * class variables declared in class MagicDictionary, as static/class variables
 * are persisted across multiple test cases. Please see here for more details.
 * 
 * @author fan
 *
 */
public class MagicDictionary {
	class TrieNode {
		TrieNode[] list = new TrieNode[26];
		boolean isLeaf = false;
	}

	TrieNode root;

	/** Initialize your data structure here. */
	public MagicDictionary() {
		root = new TrieNode();
	}

	/** Build a dictionary through a list of words */
	public void buildDict(String[] dict) {
		for (String word : dict) {
			TrieNode node = root;
			for (Character c : word.toCharArray()) {
				if (node.list[c - 'a'] == null) {
					node.list[c - 'a'] = new TrieNode();
				}
				node = node.list[c - 'a'];
			}
			node.isLeaf = true;
		}
	}

	/**
	 * Returns if there is any word in the trie that equals to the given word after
	 * modifying exactly one character
	 */
	public boolean search(String word) {
		char[] cArray = word.toCharArray();
		for (int i = 0; i < cArray.length; i++) {
			for (char c = 'a'; c <= 'z'; c++) {
				if (c == cArray[i])
					continue;
				char temp = cArray[i];
				cArray[i] = c;
				if (checkTrieTree(new String(cArray)))
					return true;
				cArray[i] = temp;
			}
		}
		return false;
	}

	private boolean checkTrieTree(String word) {
		TrieNode cur = root;
		for (char c : word.toCharArray()) {
			if (cur.list[c - 'a'] == null) {
				return false;
			}
			cur = cur.list[c - 'a'];
		}
		return cur.isLeaf;
	}

	/**
	 * Your MagicDictionary object will be instantiated and called as such:
	 * MagicDictionary obj = new MagicDictionary(); obj.buildDict(dict); boolean
	 * param_2 = obj.search(word);
	 */

}

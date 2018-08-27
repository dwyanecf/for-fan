package com.fanchen.clearmind.lianjia;

class TrieNode {
    public char val;
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];

    public TrieNode() {
        this.val = ' ';
    }

    TrieNode(char c) {
        TrieNode node = new TrieNode();
        node.val = c;
    }
}

public class Trie {

    TrieNode node;

    /**
     * Initialize your data structure here.
     */

    public Trie() {
        node = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {

        TrieNode cur = node;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode cur = node;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) return false;
            cur = cur.children[c - 'a'];
        }
        return cur.isWord;

    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode cur = node;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.children[c - 'a'] == null) return false;
            cur = cur.children[c - 'a'];
        }
        return true;
    }
}

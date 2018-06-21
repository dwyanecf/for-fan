package com.fanchen.clearmind.concept;

public class TrieNode {
    public TrieNode[] list = new TrieNode[26];
    public boolean isLeaf = false;

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
            if (cur.list[index] == null) {
                break;
            } else {
                sb.append(word.charAt(i));
                cur = cur.list[index];
                if (cur.isLeaf) {
                    return sb.toString();
                } else {
                    i++;
                }
            }
        }
        return word;
    }
}


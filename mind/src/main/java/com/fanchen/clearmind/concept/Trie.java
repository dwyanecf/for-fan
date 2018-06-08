package com.fanchen.clearmind.concept;

import java.util.Arrays;

public class Trie {

    public int sons;
    public TrieNode node;

    public Trie(int sons) {
        this.sons = sons;
        node = new TrieNode();
    }

    public void insert(String word) {
        insert(word, node);
    }

    public void insert(String word, TrieNode node) {
        if (word.isEmpty()) {
            node.isWord = true;
            return;
        }
        if (node.nextCollection[word.charAt(0)] == null)
            node.nextCollection[word.charAt(0)] = new TrieNode();
        insert(word.substring(1), node.nextCollection[word.charAt(0)]);
    }

    public boolean search(String word) {
        return search(word, node, 0);
    }

    public boolean search(String word, TrieNode curNode, int changeCount) {
        if (curNode == null || changeCount > 1 || (!curNode.isWord) && word.isEmpty())
            return false;
        if (curNode.isWord && word.isEmpty())
            return changeCount == 1;
        return Arrays.stream(curNode.nextCollection).anyMatch(nextNode -> search(word.substring(1), nextNode,
                curNode.nextCollection[word.charAt(0)] == nextNode ? changeCount : changeCount + 1));
    }

    private class TrieNode {
        TrieNode nextCollection[] = new TrieNode[sons];
        boolean isWord;
    }

}

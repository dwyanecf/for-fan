package com.fanchen.clearmind.leetcode.map.medium;

import com.fanchen.clearmind.concept.TrieNode;

import java.util.List;

/**
 * In English, we have a concept called root,
 * which can be followed by some other words to form another longer word - let's call this word successor.
 * For example, the root an, followed by other, which can form another word another.
 *
 * Now, given a dictionary consisting of many roots and a sentence.
 * You need to replace all the successor in the sentence with the root forming it.
 * If a successor has many roots can form it, replace it with the root with the shortest length.
 *
 * You need to output the sentence after the replacement.
 *
 * Example 1:
 * Input: dict = ["cat", "bat", "rat"]
 * sentence = "the cattle was rattled by the battery"
 * Output: "the cat was rat by the bat"
 * Note:
 * The input will only have lower-case letters.
 * 1 <= dict words number <= 1000
 * 1 <= sentence words number <= 1000
 * 1 <= root length <= 100
 * 1 <= sentence words length <= 1000
 */
public class ReplaceWords {
    public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = new TrieNode();
        for(String s:dict){
            root.addWord(s,0);
        }
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(" ");
            sb.append(root.searchWord(word));
        }
        return sb.toString().trim();
    }
}

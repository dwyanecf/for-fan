package com.fanchen.clearmind.lianjia;

import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class WordLadder {
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        for (int time = 1; !q.isEmpty(); time++) {
            for (int i =q.size(); i>0; i--) {
                String s = q.poll();
                if (s.equals(endWord)) return time;
                for (int index = 0; index < s.length(); index++) {
                    char[] cur = s.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (cur[index] == c) continue;
                        cur[index] = c;
                        String str = String.valueOf(cur);
                        if (visited.add(str) && dict.contains(str)) {
                            q.offer(str);
                        }
                    }
                }
            }
        }
        return 0;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<String>(wordList);
        if(!dict.contains(endWord)){
            return 0;
        }
        Set<String> set1 = new HashSet<String>();
        Set<String> set2 = new HashSet<String>();


        set1.add(beginWord);
        set2.add(endWord);

        return helper(dict, set1, set2, 1);
    }

    int helper(Set<String> dict, Set<String> set1, Set<String> set2, int level) {
        if (set1.isEmpty()) return 0;

        if (set1.size() > set2.size()) return helper(dict, set2, set1, level);

        // remove words from both ends
        for (String word : set1) { dict.remove(word); };
        for (String word : set2) { dict.remove(word); };

        // the set for next level
        Set<String> set = new HashSet<String>();

        // for each string in the current level
        for (String str : set1) {
            for (int i = 0; i < str.length(); i++) {
                char[] chars = str.toCharArray();

                // change letter at every position
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chars[i] = ch;
                    String word = new String(chars);

                    // found the word in other end(set)
                    if (set2.contains(word)) {
                        return level + 1;
                    }

                    // if not, add to the next level
                    if (dict.contains(word)) {
                        set.add(word);
                    }
                }
            }
        }

        return helper(dict, set2, set, level + 1);
    }
}

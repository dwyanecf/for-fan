package com.fanchen.clearmind.lianjia;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder1 {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        set1.add(beginWord);
        set2.add(endWord);
        return helper(dict, set1, set2, 1);
    }

    private static int helper(Set<String> dict, Set<String> set1, Set<String> set2, int level) {
        if (set1.isEmpty()) return 0;
        if (set1.size() > set2.size()) return helper(dict, set2, set1, level);

        for (String s1 : set1) dict.remove(s1);
        for (String s2 : set2) dict.remove(s2);

        Set<String> nextSet = new HashSet<>();
        for (String s : set1) {
            for (int i = 0; i < s.length(); i++) {
                char[] c = s.toCharArray();
                for (char cur = 'a'; cur <= 'z'; cur++) {
                    c[i] = cur;
                    String str = new String(c);

                    if (set2.contains(str)) {
                        return level + 1;
                    }
                    if (dict.contains(str)) {
                        nextSet.add(str);
                    }
                }
            }
        }
        return helper(dict, set2, nextSet, level + 1);
    }

    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        ladderLength(start,end,wordList);
    }
}

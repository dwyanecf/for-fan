package com.fanchen.clearmind.leetcode.newproblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a list of words, we may encode it by writing a reference string S and a list of indexes A.
 *
 * For example, if the list of words is ["time", "me", "bell"],
 * we can write it as S = "time#bell#" and indexes = [0, 2, 5].
 *
 * Then for each index, we will recover the word by reading from the reference string
 * from that index until we reach a "#" character.
 *
 * What is the length of the shortest reference string S possible that encodes the given words?
 *
 * Example:
 *
 * Input: words = ["time", "me", "bell"]
 * Output: 10
 * Explanation: S = "time#bell#" and indexes = [0, 2, 5].
 * Note:
 *
 * 1 <= words.length <= 2000.
 * 1 <= words[i].length <= 7.
 * Each word has only lowercase letters.
 */
public class ShortEncodingofWords {
    public int minimumLengthEncoding(String[] words) {
        Set<String> s = new HashSet<>(Arrays.asList(words));
        for (String w : words)
            for (int i = 1; i < w.length(); ++i)
                s.remove(w.substring(i));
        int res = 0;
        for (String w : s) res += w.length() + 1;
        return res;
    }
}

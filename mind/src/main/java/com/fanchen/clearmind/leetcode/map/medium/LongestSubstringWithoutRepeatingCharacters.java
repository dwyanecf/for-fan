package com.fanchen.clearmind.leetcode.map.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 *
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 *
 * Given "bbbbb", the answer is "b", with the length of 1.
 *
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
 * "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();
        int lo = 0;
        int hi = 0;
        int currentLength = 0;
        char[] c = s.toCharArray();
        Set<Character> set = new HashSet<>();
        while (hi < c.length) {
            if (!set.contains(c[hi])) {
                set.add(c[hi++]);
                currentLength = Math.max(currentLength, set.size());
            } else {
                //keep deleting until delete the current character which is duplicate
                set.remove(c[lo++]);
            }
        }
        return currentLength;
    }
}

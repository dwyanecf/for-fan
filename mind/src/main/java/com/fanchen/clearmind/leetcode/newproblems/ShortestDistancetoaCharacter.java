package com.fanchen.clearmind.leetcode.newproblems;

/**
 *
 Given a string S and a character C, return an array of integers representing
 the shortest distance from the character C in the string.

 Example 1:

 Input: S = "loveleetcode", C = 'e'
 Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]


 Note:

 S string length is in [1, 10000].
 C is a single character, and guaranteed to be in string S.
 All letters in S and C are lowercase.


 */
public class ShortestDistancetoaCharacter {
    public int[] shortestToChar(String S, char C) {
        char[] s = S.toCharArray();
        int n = s.length;
        int pos = -n;
        int[] res = new int[n];
        for (int i = 0; i < s.length; i++) {
            if (s[i] == C) pos = i;
            res[i] = i - pos;
        }
        for (int i = s.length - 1; i >= 0; i--) {
            if (s[i] == C) pos = i;
            res[i] = Math.min(res[i], Math.abs(pos - i));
        }
        return res;
    }
}

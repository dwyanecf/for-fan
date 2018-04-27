package com.fanchen.clearmind.leetcode.string;

/**
 * Given a non-empty string check if it can be constructed by taking a substring of it
 * and appending multiple copies of the substring together.
 * You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 * Example 1:
 * Input: "abab"
 *
 * Output: True
 *
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 * Input: "aba"
 *
 * Output: False
 * Example 3:
 * Input: "abcabcabcabc"
 *
 * Output: True
 *
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        if(s==null ||s.length()<=1) return false;
        for(int i=s.length()/2;i>=1;i--){
            if(s.length()% i ==0){
                int j = i;
                String sb = s.substring(0,j);
                while (s.indexOf(sb,j)==j) j= j+i;
                if(j == s.length()) return true;
            }
        }
        return false;
    }
}

package com.fanchen.clearmind.leetcode.string;

/**
 * Given a string and an integer k, you need to reverse the first k characters
 * for every 2k characters counting from the start of the string. If there are less than k characters left,
 * reverse all of them. If there are less than 2k but greater than or equal to k characters,
 * then reverse the first k characters and left the other as original.
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Restrictions:
 * The string consists of lower English letters only.
 * Length of the given string and k will in the range [1, 10000]
 */
public class ReverseStringII {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() <= 1) return s;
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            int index = Math.min(i + k-1,s.length()-1);
            reverseString(str, i, index);
        }
        return new String(str);
    }

    public void reverseString(char[] str, int i, int index) {
        while (i < index) {
            char temp = str[i];
            str[i++] = str[index];
            str[index++] = temp;
        }
    }
}

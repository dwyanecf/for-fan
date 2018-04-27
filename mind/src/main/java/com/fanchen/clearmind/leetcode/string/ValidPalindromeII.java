package com.fanchen.clearmind.leetcode.string;

/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 * <p>
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * Note:
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return isPa(s, l - 1, r) || isPa(s, l, r + 1);
            l++;
            r--;
        }
        return true;
    }

    private boolean isPa(String s, int i, int r) {
        while (++i < --r) {
            if (s.charAt(i) != s.charAt(r)) return false;
        }
        return true;
    }
}

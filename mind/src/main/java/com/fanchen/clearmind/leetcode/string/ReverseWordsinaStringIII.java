package com.fanchen.clearmind.leetcode.string;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * <p>
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class ReverseWordsinaStringIII {
    public String reverseWords(String s) {
        String str = s.trim();
        String[] words = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(" " + reverseString(word));
        }
        return sb.reverse().toString().trim();

    }

    public String reverseString(String s) {
        if (s == null || s.length() < 1) return "";
        int l = 0;
        int r = s.length() - 1;
        char temp = 0;
        char[] sArray = s.toCharArray();
        while (l < r) {
            temp = sArray[l];
            sArray[l] = sArray[r];
            sArray[r] = temp;
            l++;
            r--;
        }
        return new String(sArray);
    }
}

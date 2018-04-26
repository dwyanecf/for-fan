package com.fanchen.clearmind.leetcode.string;

/**
 * Write a function that takes a string as input and returns the string reversed.
 * <p>
 * Example:
 * Given s = "hello", return "olleh".
 */
public class ReverseString {
    public String reverseString(String s) {
        if(s == null || s.length()<1) return "";
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

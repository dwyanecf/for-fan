package com.fanchen.clearmind.leetcode.TwoPointer;

/**
 * Write a function that takes a string as input and returns the string reversed.
 *
 * Example:
 * Given s = "hello", return "olleh".
 */
public class ReverseString {
    public String reverseString(String s) {
        if(s == null || s.length() < 1) return "";
        char[] sArray = s.toCharArray();
        int lo = 0;
        int hi = s.length()-1;
        while(lo < hi){
            char temp = sArray[lo];
            sArray[lo++] = sArray[hi];
            sArray[hi--] = temp;
        }
        return new String(sArray);
    }
}

package com.fanchen.clearmind.leetcode.string;

public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        if (S == null || S.length() == 0) return S;
        char[] c = S.toCharArray();
        int lo = 0;
        int hi = c.length - 1;
        while (lo < hi) {
            while (lo < hi && !Character.isLetter(c[lo])) {
                lo++;
            }
            while (lo < hi && !Character.isLetter(c[hi])) {
                hi--;
            }
            char temp = c[lo];
            c[lo] = c[hi];
            c[hi] = temp;
            lo++;
            hi--;
        }
        return String.valueOf(c);
    }
}

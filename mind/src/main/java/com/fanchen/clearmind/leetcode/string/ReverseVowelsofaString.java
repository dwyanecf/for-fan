package com.fanchen.clearmind.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * <p>
 * Example 1:
 * Given s = "hello", return "holle".
 * <p>
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 * <p>
 * Note:
 * The vowels does not include the letter "y".
 */
public class ReverseVowelsofaString {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        char[] c = s.toCharArray();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int r = s.length();
        int l = 0;
        while (l < r) {
            while (l < r && !set.contains(c[l])) {
                l++;
            }
            while (l < r && !set.contains(c[r])) {
                r--;
            }
            char temp = c[l];
            c[l++] = c[r];
            c[r--] = temp;
        }
        return new String(c);
    }
}


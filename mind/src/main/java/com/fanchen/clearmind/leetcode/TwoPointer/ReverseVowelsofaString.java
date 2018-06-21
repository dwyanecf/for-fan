package com.fanchen.clearmind.leetcode.TwoPointer;

import java.util.HashSet;
import java.util.Set;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 * Given s = "hello", return "holle".
 *
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 *
 * Note:
 * The vowels does not include the letter "y".
 */
public class ReverseVowelsofaString {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
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
        char[] sArray = s.toCharArray();
        int lo = 0;
        int hi = sArray.length-1;
        while (lo < hi){
            while(lo < hi && !set.contains(sArray[lo])) lo++;
            while(lo < hi && !set.contains(sArray[hi])) hi--;
            char temp = sArray[lo];
            sArray[lo++] = sArray[hi];
            sArray[hi--] = temp;
        }
        return new String(sArray);
    }
}

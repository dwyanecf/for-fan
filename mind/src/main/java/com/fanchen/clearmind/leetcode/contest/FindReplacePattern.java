package com.fanchen.clearmind.leetcode.contest;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindReplacePattern {
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            char[] patternHome = new char[256];
            char[] wordHome = new char[256];
            boolean count = true;
            for (int i = 0; i < pattern.length(); i++) {
                //pattern digit
                char patternDigit = pattern.charAt(i);
                //word digit
                char wordDigit = word.charAt(i);
                if (patternHome[patternDigit] > 0 && patternHome[patternDigit] != wordDigit) {
                    count = false;
                }
                if (wordHome[wordDigit] > 0 && wordHome[wordDigit] != patternDigit) {
                    count = false;
                }
                patternHome[patternDigit] = wordDigit;
                wordHome[wordDigit] = patternDigit;
            }
            if (count)
                ans.add(word);
        }
        return ans;
    }

}

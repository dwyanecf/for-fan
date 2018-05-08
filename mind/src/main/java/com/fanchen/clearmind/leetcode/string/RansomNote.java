package com.fanchen.clearmind.leetcode.string;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines,
 * write a function that will return true if the ransom note can be constructed from the magazines ;
 * otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] appearance = new int[128];
        for(char c:magazine.toCharArray()) appearance[c-'a']++;
        for(char a:ransomNote.toCharArray()){
            if(--appearance[a-'a']<0) return false;
        }
        return true;
    }
}

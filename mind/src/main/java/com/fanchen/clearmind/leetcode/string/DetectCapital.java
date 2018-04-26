package com.fanchen.clearmind.leetcode.string;

/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital if it has more than one letter, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * Example 1:
 * Input: "USA"
 * Output: True
 * Example 2:
 * Input: "FlaG"
 * Output: False
 * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 */
public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        return checkAllUpper(word)||checkAllLower(word)||checkWord(word);
    }

    private boolean checkWord(String word) {
        if (!Character.isUpperCase(word.charAt(0))) return false;
        for(int i =1;i<word.length();i++){
            if(!Character.isLowerCase(word.charAt(i))){
                return false;
            }
        }
        return true;
    }

    private boolean checkAllLower(String word) {
        for(Character c:word.toCharArray()){
            if(!Character.isLowerCase(c)){
                return false;
            }
        }
        return true;
    }

    private boolean checkAllUpper(String word) {
        for(Character c:word.toCharArray()){
            if(!Character.isUpperCase(c)){
                return false;
            }
        }
        return true;
    }


}

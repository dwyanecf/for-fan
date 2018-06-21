package com.fanchen.clearmind.leetcode.TwoPointer;

/**
 *
 Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 Note: For the purpose of this problem, we define empty string as valid palindrome.

 Example 1:

 Input: "A man, a plan, a canal: Panama"
 Output: true
 Example 2:

 Input: "race a car"
 Output: false
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s== null || s.length() <=1) return true;
        char[] str = s.toCharArray();
        int lo = 0;
        int hi = str.length-1;
        while(lo < hi){
            while (lo < hi && !Character.isLetterOrDigit(str[lo])) lo++;
            while (lo < hi && !Character.isLetterOrDigit(str[hi])) hi--;
            if(Character.toLowerCase(str[lo++]) != Character.toLowerCase(str[hi--])) return false;
        }
        return true;
    }
}

package com.fanchen.clearmind.lianjia;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s==null || s.length()<=1) return true;
        char[] c = s.toCharArray();
        int l = 0;
        int r = c.length-1;
        while(l<r){
            while(l<r&&!Character.isLetterOrDigit(c[l])){
                l++;
            }
            while(l<r&&!Character.isLetterOrDigit(c[r])){
                r--;
            }
            if(Character.toLowerCase(c[l++]) != Character.toLowerCase(c[r--])){
                return false;
            }
        }
        return true;
    }
}

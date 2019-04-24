package com.fanchen.clearmind.lianjia;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int res =0;
        for(int i=0;i<s.length();i++){
            res = res + isPalindromString(i,i,s) + isPalindromString(i,i+1,s);

        }
        return res;
    }

    public int isPalindromString(int l, int r, String s){
        int count =0;
        while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
            l--;
            r++;
            count++;
        }
        return count;
    }
}

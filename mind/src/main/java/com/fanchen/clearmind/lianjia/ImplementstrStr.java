package com.fanchen.clearmind.lianjia;

public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if(needle == null|| needle.length()==0) return 0;
        int len = haystack.length()-needle.length();
        for(int i=0;i<=len;i++){
            String cur =haystack.substring(i,i+needle.length());
            if(needle.equals(cur)) return i;
      }
      return -1;
    }
}

package com.fanchen.clearmind.zillow.VO;

import java.util.HashSet;
import java.util.Set;

public class LC3LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		int res = 0;
		if (s == null || s.length() == 0)
			return res;
		int lo = 0;
		int hi = 0;
		int n = s.length();
		Set<Character> set = new HashSet<>();
		while (hi < n) {
			if (set.add(s.charAt(hi))) {
				res = Math.max(res, set.size());
				hi++;
			} else {
				set.remove(s.charAt(lo++));
			}
		}
		return res;
	}
	
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] table = new int[256];
        int count =0;
        int lo = 0;
        int res = 0;
        for(int hi =0; hi<s.length();hi++){
            if(table[s.charAt(hi)]++ == 0){
                count++;
            }
            if(count > 2){
                while(--table[s.charAt(lo++)] >0);
                count--;
            }
            res = Math.max(res, hi-lo+1);
        }
        return res;
    }
}

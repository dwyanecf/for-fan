package com.fanchen.clearmind.leetcode.binarysearch;

public class SearchinaSortedArrayofUnknownSize {
	public int search(ArrayReader reader, int target) {
        int hi = 1;
        while(reader.get(hi)<target){
            hi = hi*2;
        }
        int lo = hi/2;
        while(lo < hi){
            int mid = lo + (hi -lo)/2;
            if(reader.get(mid) == target){
                return mid;
            }
            else if(reader.get(mid)> target){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }
        return reader.get(lo) == target ? lo : -1;
    }
}

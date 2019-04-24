package com.fanchen.clearmind.lianjia;

public class Sqrt {
    public int mySqrt(int x) {
        int left =1;
        int right =x;
        while(left<=right){
            int mid = left+ (right-left)/2;
            if((x/mid)<mid){
                right = mid -1;
            }else{
                if((x/(mid+1))<(mid+1)){
                    return mid;
                }
                left =mid +1;
            }
        }
        return 0;
    }
}

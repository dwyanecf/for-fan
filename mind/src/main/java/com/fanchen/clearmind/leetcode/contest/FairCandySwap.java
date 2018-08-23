package com.fanchen.clearmind.leetcode.contest;

/**
 * Alice and Bob have candy bars of different sizes: A[i] is the size of the i-th bar of candy that Alice has, and B[j] is the size of the j-th bar of candy that Bob has.
 *
 * Since they are friends, they would like to exchange one candy bar each so that after the exchange, they both have the same total amount of candy.  (The total amount of candy a person has is the sum of the sizes of candy bars they have.)
 *
 * Return an integer array ans where ans[0] is the size of the candy bar that Alice must exchange, and ans[1] is the size of the candy bar that Bob must exchange.
 *
 * If there are multiple answers, you may return any one of them.  It is guaranteed an answer exists.
 */
public class FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int total = 0;
        int sumA = 0;
        for(int a:A){
            total+=a;
            sumA+=a;
        }
        for(int b:B){
            total+=b;
        }
        total = total/2;
        int difference =total-sumA;
        int[] ans = new int[2];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                if(B[j]-A[i] == difference){
                    ans[0]=A[i];
                    ans[1]=B[j];
                    return ans;
                }
            }
        }
        return ans;
    }
}

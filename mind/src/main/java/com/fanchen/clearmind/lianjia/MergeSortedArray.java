package com.fanchen.clearmind.lianjia;

/**
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while(n>0){
            nums1[n+m-1] = (n==0 || nums2[n-1]<nums1[m-1])? nums1[--m]:nums2[--n];
        }
    }
}

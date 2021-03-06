package com.fanchen.clearmind.leetcode.dp;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 */
public class NumArray {
    public int[] adds;
    public NumArray(int[] nums) {
        adds = new int[nums.length];
        int sum=0;
        for(int i =0; i<nums.length;i++)
        {
            sum += nums[i];
            adds[i]= sum;
        }
    }

    public int sumRange(int i, int j) {
        return i==0? adds[j]: adds[j]-adds[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
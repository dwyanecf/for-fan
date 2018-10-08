package com.fanchen.clearmind.GroupSolve.DP.easy;

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


/**
 * ["NumArray"]
 * [[[]]]
 */
public class NumArray {
    public int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length];
        if(nums==null || nums.length==0) return;
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

    }

    public int sumRange(int i, int j) {
        return i==0? sum[j]: sum[j] - sum[i-1];
    }
}

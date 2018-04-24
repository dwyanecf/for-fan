package com.fanchen.clearmind.leetcode.dp;

/**
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.
 * <p>
 * Example 1:
 * Input: [1,12,-5,-6,50,3], k = 4
 * Output: 12.75
 * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 * Note:
 * 1 <= k <= n <= 30,000.
 * Elements of the given array will be in the range [-10,000, 10,000].
 */
public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int[] sum = new int [nums.length+1];
        sum[0] = 0;
        for(int i=0;i<nums.length;i++){
            sum[i+1] = sum[i]+nums[i];
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i< sum.length - k ;i++){
            int cur = sum[i+k]-sum[i];
            max = Math.max(max,cur);
        }
        return (double)max/k;
    }
}

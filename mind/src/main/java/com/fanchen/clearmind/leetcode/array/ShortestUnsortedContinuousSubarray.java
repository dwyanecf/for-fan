package com.fanchen.clearmind.leetcode.array;

/**
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order,
 * then the whole array will be sorted in ascending order, too.
 * <p>
 * You need to find the shortest such subarray and output its length.
 * <p>x
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * Note:
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 */
public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int end = -2;
        int start = -1;
        int max = nums[0];
        int min = nums[n - 1];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n - 1 - i]);
            if (nums[i] < max) end = i;  //从左向右 找到比目前max小的元素
            if (nums[n - 1 - i] > min) start = n - 1 - i; //从右向左 找到比目前min大的元素
        }
        return end - start + 1;
    }
}

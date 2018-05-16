package com.fanchen.clearmind.leetcode.array;

/**
 * In a given integer array nums, there is always exactly one largest element.
 *
 * Find whether the largest element in the array is at least twice as much as every other number in the array.
 *
 * If it is, return the index of the largest element, otherwise return -1.
 *
 * Example 1:
 *
 * Input: nums = [3, 6, 1, 0]
 * Output: 1
 * Explanation: 6 is the largest integer, and for every other number in the array x,
 * 6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.
 *
 *
 * Example 2:
 *
 * Input: nums = [1, 2, 3, 4]
 * Output: -1
 * Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.
 *
 *
 * Note:
 *
 * nums will have a length in the range [1, 50].
 * Every nums[i] will be an integer in the range [0, 99].
 */
public class LargestNumberLeastTwiceOthers {
    public int dominantIndex(int[] nums) {
        if(nums.length == 1) return 0;
        int max1 = nums[0];
        int max2 = nums[0];
        int index =0;
        for(int i =1;i<nums.length;i++){
            if(nums[i] > max1){
                max2 = max1;
                index= i;
                max1 = nums[i];
            }else if(nums[i] > max2){
                max2 = nums[i];
            }
        }
        if(max1 >= 2*max2){
            return index;
        }
        else return -1;
    }
}

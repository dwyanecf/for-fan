package com.fanchen.clearmind.leetcode.newproblems;

/**
 * Given an array A of integers, return true if and only if it is a valid mountain array.
 * <p>
 * Recall that A is a mountain array if and only if:
 * <p>
 * A.length >= 3
 * There exists some i with 0 < i < A.length - 1 such that:
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[B.length - 1]
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [2,1]
 * Output: false
 * Example 2:
 * <p>
 * Input: [3,5,5]
 * Output: false
 * Example 3:
 * <p>
 * Input: [0,3,2,1]
 * Output: true
 */
public class ValidMountainArray {

    /**
     * [14,82,89,84,79,70,70,68,67,66,63,60,58,54,44,43,32,28,26,25,22,15,13,12,10,8,7,5,4,3]
     * @param A
     * @return
     */
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3) return false;
        boolean up = false;
        boolean down = false;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                if (down) {
                    return false;
                }
                if (!up) {
                    up = true;
                }
            } else if (A[i] < A[i - 1]) {
                if (!up) {
                    return false;
                }
                if (!down) {
                    down = true;
                }
            }else{
                return false;
            }
        }
        return down && up;
    }
}

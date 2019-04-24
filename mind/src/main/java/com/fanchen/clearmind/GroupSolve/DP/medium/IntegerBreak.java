package com.fanchen.clearmind.GroupSolve.DP.medium;

/**
 * Given a positive integer n, break it into the sum of at least two positive integers
 * and maximize the product of those integers. Return the maximum product you can get.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * Example 2:
 *
 * Input: 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        return helper(n, 1);
    }

    public int helper(int n, int total) {
        switch (n) {
            case 2:
                return total;
            case 3:
                return 2 * total;
            case 4:
                return 4 * total;
            case 5:
                return 6 * total;
            case 6:
                return 9 * total;
            default:
                return helper(n - 3, 3 * total);
        }
    }
}

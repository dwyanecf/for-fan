package com.fanchen.clearmind.leetcode.binarysearch;

/**
 * Given a positive integer num, write a function which returns True if num is a
 * perfect square else False.
 * <p>
 * Note: Do not use any built-in library function such as sqrt.
 * <p>
 * Example 1:
 * <p>
 * Input: 16 Returns: True Example 2:
 * <p>
 * Input: 14 Returns: False
 */
public class ValidPerfectSquare {
	public boolean isPerfectSquare(int num) {
		int lo = 1;
		int hi = num;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (mid > num / mid) {
				hi = mid - 1;
			} else if (mid < num / mid) {
				lo = mid + 1;
			} else {
				return mid * mid == num;
			}
		}
		return false;
	}
}

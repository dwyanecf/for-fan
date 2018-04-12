package com.fanchen.clearmind.leetcode.bit;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND
 * of all numbers in this range, inclusive.
 * 
 * For example, given the range [5, 7], you should return 4.
 * 
 * @author fan
 *
 */
public class Bitwise {
	public int rangeBitwiseAnd(int m, int n) {
		if (m == 0)
			return 0;
		int pointer = 1;
		while (m != n) {
			m >>= 1;
			n >>= 1;
			pointer <<= 1;
		}
		return m * pointer;
	}
}

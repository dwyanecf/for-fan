package com.fanchen.clearmind.leetcode.binarysearch;

/**
 * You have a total of n coins that you want to form in a staircase shape, where
 * every k-th row must have exactly k coins.
 *
 * Given n, find the total number of full staircase rows that can be formed.
 *
 * n is a non-negative integer and fits within the range of a 32-bit signed
 * integer.
 *
 Example 1:

n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.
Example 2:

n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.
 */
public class ArrangingCoins {
	public static int arrangeCoins(int n) {
		if (n < 2) {
			return n;
		}
		int lo = 0;
		int hi = n;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			long count = mid * (1L + mid) / 2;
			if (count == n) {
				return mid;
			}
			if (count < n) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return lo - 1;
	}

	public static void main(String[] args) {
		System.out.println(arrangeCoins(19));
	}
}

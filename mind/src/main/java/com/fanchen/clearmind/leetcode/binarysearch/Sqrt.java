package com.fanchen.clearmind.leetcode.binarysearch;

public class Sqrt {
	public int mySqrt(int x) {
		if (x == 0 || x == 1)
			return x;
		int lo = 0;
		int hi = x;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (mid == x / mid) {
				return mid;
			}
			if (mid > x / mid) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		return hi - 1;
	}
}

package com.fanchen.clearmind.leetcode.binarysearch;

public class FirstBadVersion {
	public int firstBadVersion(int n) {
		int lo = 1;
		int hi = n;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (isBadVersion(mid)) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		return lo;
	}

	private boolean isBadVersion(int mid) {
		// TODO Auto-generated method stub
		return false;
	}
}
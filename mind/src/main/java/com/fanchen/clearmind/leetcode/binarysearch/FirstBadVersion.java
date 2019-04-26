package com.fanchen.clearmind.leetcode.binarysearch;
/**
 * Example:

Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version. 

 * @author fachen
 *
 */
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

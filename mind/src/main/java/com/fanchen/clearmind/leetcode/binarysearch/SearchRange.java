package com.fanchen.clearmind.leetcode.binarysearch;

public class SearchRange {
	public int[] searchRange(int[] A, int target) {
		int start = firstGreaterEqual(A, target);
		if (start == A.length || A[start] != target) {
			return new int[] { -1, -1 };
		}
		return new int[] { start, firstGreaterEqual(A, target + 1) - 1 };
	}

	// find the first number that is greater than or equal to target.
	// could return A.length if target is greater than A[A.length-1].
	// actually this is the same as lower_bound in C++ STL.
	private int firstGreaterEqual(int[] A, int target) {
		int low = 0, high = A.length;
		while (low < high) {
			int mid = low + ((high - low) >> 1);
			// low <= mid < high
			if (A[mid] >= target) {
				high = mid;
			} else {
				// should not be mid-1 when A[mid]==target.
				// could be mid even if A[mid]>target because mid<high.
				low = mid + 1;
			}
		}
		return low;
	}
}

/*
 * Copyright (C) 2019 Copart, Inc. All rights reserved.
 */
package com.fanchen.clearmind.leetcode.binarysearch;

/**
 * @author fachen
 *
 */
public class MergeTwoSortedArray {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int length = nums1.length + nums2.length;
		if (length % 2 == 1) {
			return kth(nums1, 0, nums2, 0, length / 2 + 1);
		} else {
			return (double) (kth(nums1, 0, nums2, 0, length / 2) + kth(nums1, 0, nums2, 0, length / 2 + 1)) / 2;
		}
	}

	private static int kth(int[] a, int aLeft, int[] b, int bLeft, int k) {
		// if aLeft is out of boundary, return the kth element in b
		if (aLeft >= a.length) {
			return b[bLeft + k - 1];
		}
		// if bLeft is out of boundary, return the kth element in a
		if (bLeft >= b.length) {
			return a[aLeft + k - 1];
		}
		// if only one element left, return the smaller one.
		if (k == 1) {
			return Math.min(a[aLeft], b[bLeft]);
		}
		// find out the k/2 th element in each array
		int aMid = aLeft + k / 2 - 1;
		int bMid = bLeft + k / 2 - 1;
		// if k / 2 th element is out of bound in one array, then the target element is
		// possible to there, we have to eliminate other array
		// in other word, we can extends the array to be a: 1,2,INF,INF,INF, when k is >
		// 2
		int aVal = aMid >= a.length ? Integer.MAX_VALUE : a[aMid];
		int bVal = bMid >= b.length ? Integer.MAX_VALUE : b[bMid];
		// value comparison
		if (aVal > bVal) {
			return kth(a, aLeft, b, bMid + 1, k - k / 2);
		} else {
			return kth(a, aMid + 1, b, bLeft, k - k / 2);
		}
	}

	public static void main(String[] args) {
		findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 });
	}
}

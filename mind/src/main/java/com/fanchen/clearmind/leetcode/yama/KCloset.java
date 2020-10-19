package com.fanchen.clearmind.leetcode.yama;

import java.util.Arrays;

public class KCloset {

	public int[][] kClosest(int[][] points, int K) {
		int lo = 0;
		int hi = points.length - 1;
		while (lo < hi) {
			int mid = helper(points, lo, hi);
			if (mid == K) {
				break;
			} else if (mid < K) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}

		return Arrays.copyOfRange(points, 0, K);
	}

	public int helper(int[][] p, int l, int r) {
		int[] pivotal = p[l];
		while (l < r) {
			while (l < r && compare(p[r], pivotal) >= 0)
				r--;
			p[l] = p[r];
			while (l < r && compare(p[l], pivotal) <= 0)
				l++;
			p[r] = p[l];
		}
		p[l] = pivotal;
		return l;
	}

	public int compare(int[] p1, int[] p2) {
		return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
	}

	public static void main(String[] args) {
		int[][] points = { { 1, 3 }, { -2, 2 } };
		int k = 1;
		KCloset object = new KCloset();
		object.kClosest(points, k);
	}

}

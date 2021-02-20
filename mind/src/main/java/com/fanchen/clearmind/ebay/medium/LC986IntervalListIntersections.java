package com.fanchen.clearmind.ebay.medium;

import java.util.ArrayList;
import java.util.List;

public class LC986IntervalListIntersections {
	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
		if (A == null || A.length == 0 || B == null || B.length == 0)
			return new Interval[] {};
		int aLen = A.length;
		int bLen = B.length;
		List<Interval> res = new ArrayList<>();
		int i = 0;
		int j = 0;
		while (i < aLen && j < bLen) {
			Interval a = A[i];
			Interval b = B[j];

			int startMax = Math.max(a.start, b.start);
			int endMin = Math.min(a.end, b.end);

			if (endMin >= startMax) {
				res.add(new Interval(startMax, endMin));
			}

			if (a.end == endMin)
				i++;
			if (b.end == endMin)
				j++;
		}
		int len = res.size();
		Interval[] ans = new Interval[len];
		for (int k = 0; k < len; k++) {
			ans[k] = res.get(k);
		}
		return ans;
	}

	public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
		if (firstList == null || firstList.length == 0 || secondList == null || secondList.length == 0)
			return new int[][] {};
		int aLen = firstList.length;
		int bLen = secondList.length;
		List<int[]> res = new ArrayList<>();
		int i = 0;
		int j = 0;
		while (i < aLen && j < bLen) {
			int[] a = firstList[i];
			int[] b = secondList[j];

			int startMax = Math.max(a[0], b[0]);
			int endMin = Math.min(a[1], b[1]);

			if (endMin >= startMax) {
				res.add(new int[] { startMax, endMin });
			}

			if (a[1] == endMin)
				i++;
			if (b[1] == endMin)
				j++;
		}
		int len = res.size();
		int[][] ans = new int[len][2];
		for (int k = 0; k < len; k++) {
			ans[k] = res.get(k);
		}
		return ans;
	}
}

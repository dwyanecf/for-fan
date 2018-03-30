package com.fanchen.clearmind.leetcode.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is
 * a tuple of points (i, j, k) such that the distance between i and j equals the
 * distance between i and k (the order of the tuple matters).
 * 
 * Find the number of boomerangs. You may assume that n will be at most 500 and
 * coordinates of points are all in the range [-10000, 10000] (inclusive).
 * 
 * Example: Input: [[0,0],[1,0],[2,0]]
 * 
 * Output: 2
 * 
 * Explanation: The two boomerangs are [[1,0],[0,0],[2,0]] and
 * [[1,0],[2,0],[0,0]]
 * 
 * @author fan
 *
 */
public class NumberOfBoomerangs {
	public int numberOfBoomerangs(int[][] points) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points.length; j++) {
				if (i == j)
					continue;
				int dis = calculateDistance(points[i], points[j]);
				map.put(dis, map.getOrDefault(dis, 0) + 1);

			}
			for (int value : map.values()) {
				res += value * (value - 1);
			}
			map.clear();
		}
		return res;
	}

	public int calculateDistance(int[] a, int[] b) {
		int x = a[0] - b[0];
		int y = a[1] - b[1];
		return x + y;
	}
}

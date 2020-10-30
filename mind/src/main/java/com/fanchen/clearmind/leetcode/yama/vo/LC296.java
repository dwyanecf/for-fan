package com.fanchen.clearmind.leetcode.yama.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC296 {
	
	/**
	 * A group of two or more people wants to meet and minimize the total travel distance. 
		you are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. 
		The distance is calculated usingManhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
		
		For example, given three people living at (0,0), (0,4), and(2,2):
		
		1 - 0 - 0 - 0 - 1
		|   |   |   |   |
		0 - 0 - 0 - 0 - 0
		|   |   |   |   |
		0 - 0 - 1 - 0 - 0
		The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.
		
		[思路]
		
		二维的等于一维的相加, 一维的最小点必在median点(用反证法可以证明).

	 * @param grid
	 * @return
	 */
	public int minTotalDistance(int[][] grid) {
		List<Integer> x = new ArrayList<>();
		List<Integer> y = new ArrayList<>();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					x.add(i);
					y.add(j);
				}
			}
		}

		return getMP(x) + getMP(y);
	}

	private int getMP(List<Integer> l) {
		Collections.sort(l);
		int lo = 0;
		int hi = l.size() - 1;
		int res = 0;
		while (lo < hi) {
			res += l.get(hi--) - l.get(lo++);
		}
		return res;
	}
	
	// solution: https://www.cnblogs.com/grandyang/p/5291058.html
}

package com.fanchen.clearmind.leetcode.ama;

import java.util.HashSet;
import java.util.Set;

public class NumberDistinctIslands {
	public int numDistinctIslands(int[][] grid) {
		Set<String> set = new HashSet<>();
		if (grid == null || grid.length == 0)
			return 0;
		int m = grid.length;
		int n = grid[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] != 0) {
					StringBuilder sb = new StringBuilder();
					dfs(grid, m, n, sb, i, j, "o");
					set.add(sb.toString());
				}
			}
		}

		return set.size();

	}

	private void dfs(int[][] grid, int m, int n, StringBuilder sb, int i, int j, String dir) {

		if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
			return;
		}
		grid[i][j] = 0;
		sb.append(dir);
		dfs(grid, m, n, sb, i - 1, j, "u");
		dfs(grid, m, n, sb, i + 1, j, "d");
		dfs(grid, m, n, sb, i, j - 1, "l");
		dfs(grid, m, n, sb, i, j + 1, "r");
		sb.append("b");

	}
}

package com.fanchen.clearmind.zillow.dianmian;

public class LC695MaxAreaIsland {
	int max = 0;

	public int maxAreaOfIsland(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 1) {
					max = Math.max(max, helper(i, j, row, col, grid));
				}
			}
		}
		return max;
	}

	public int helper(int i, int j, int row, int col, int[][] grid) {
		if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == 0) {
			return 0;
		}
		grid[i][j] = 0;
		return 1 + helper(i + 1, j, row, col, grid) + helper(i - 1, j, row, col, grid)
				+ helper(i, j + 1, row, col, grid) + helper(i, j - 1, row, col, grid);
	}
}

package com.fanchen.clearmind.zillow.VO;

public class LC62UniquePath {
	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		for (int j = 0; j < n; j++) {
			dp[0][j] = 1;
		}
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}

	public int uniquePathsWithObstacles(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 1) {
					grid[i][j] = 0;
				} else if (i == 0 && j == 0) {
					grid[i][j] = 1;
				} else if (i == 0 && j > 0) {
					grid[i][j] = grid[i][j - 1];
				} else if (j == 0 && i > 0) {
					grid[i][j] = grid[i - 1][j];
				} else {
					grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
				}
			}
		}
		return grid[row - 1][col - 1];
	}
}

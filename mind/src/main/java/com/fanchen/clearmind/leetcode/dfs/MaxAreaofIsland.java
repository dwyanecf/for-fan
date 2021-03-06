package com.fanchen.clearmind.leetcode.dfs;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's
 * (representing land) connected 4-directionally (horizontal or vertical.) You
 * may assume all four edges of the grid are surrounded by water.
 * 
 * Find the maximum area of an island in the given 2D array. (If there is no
 * island, the maximum area is 0.) Example 1: [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0], [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0], [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0], [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]] Given the above grid, return 6. Note the answer
 * is not 11, because the island must be connected 4-directionally. Example 2:
 * [[0,0,0,0,0,0,0,0]] Given the above grid, return 0.
 * 
 * @author fan
 *
 */
public class MaxAreaofIsland {
	public int maxAreaOfIsland(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int row = grid.length;
		int col = grid[0].length;
		int maxArea = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 1)
					maxArea = Math.max(maxArea, bfs(grid, i, j, row, col));
			}
		}
		return maxArea;
	}

	private int bfs(int[][] grid, int i, int j, int row, int col) {
		if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == 0)
			return 0;
		grid[i][j] = 0;
		return 1 + bfs(grid, i + 1, j, row, col) + bfs(grid, i - 1, j, row, col) + bfs(grid, i, j + 1, row, col)
				+ bfs(grid, i, j - 1, row, col);
	}
}

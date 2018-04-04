package com.fanchen.clearmind.leetcode.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's
 * (representing land) connected 4-directionally (horizontal or vertical.) You
 * may assume all four edges of the grid are surrounded by water.
 * 
 * Count the number of distinct islands. An island is considered to be the same
 * as another if and only if one island can be translated (and not rotated or
 * reflected) to equal the other.
 * 
 * Example 1:
 * 
 * 11000 
 * 11000 
 * 00011 
 * 00011
 * 
 * Given the above grid map, return 1.
 * 
 * 
 * @author fan
 *
 */
public class NumberOfDistinctIslands {
	public int[][] direction = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public int numDistinctIslands(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int row = grid.length;
		int col = grid[0].length;
		Set<String> set = new HashSet<>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 0)
					continue;
				set.add(getPattern(grid, row, col, i, j));
			}
		}
		return set.size();
	}

	private String getPattern(int[][] grid, int row, int col, int i, int j) {
		int rowEnd = 0;
		int colEnd = 0;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { i, j });

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			for (int[] dir : direction) {
				int x = current[0] + dir[0];
				int y = current[1] + dir[1];

				if (x < 0 || x >= row || y < 0 || y >= col || grid[x][y] == 0)
					continue;
				queue.offer(new int[] { x, y });
				grid[x][y] = 0;
				rowEnd = Math.max(rowEnd, i);
				colEnd = Math.max(colEnd, j);
			}
		}
		return getStringValue(grid, i, j, rowEnd, colEnd);
	}

	private String getStringValue(int[][] grid, int rowStart, int colStart, int rowEnd, int colEnd) {
		StringBuilder sb = new StringBuilder();
		for (int i = rowStart; i <= rowEnd; i++) {
			for (int j = colStart; j < colEnd; j++) {
				sb.append(String.valueOf(grid[i][j]));
			}
		}
		return sb.toString();
	}
}

package com.fanchen.clearmind.leetcode.bfs;

import java.util.HashSet;
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
public class NumberOfDistinctIslands2 {
	public int minValue = Integer.MAX_VALUE;
	public int mxnValue = Integer.MIN_VALUE;

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
				set.add(getPattern(grid, row, col, i, j, new int[] { minValue, mxnValue },
						new int[] { minValue, mxnValue }));
			}
		}
		return set.size();
	}

	private String getPattern(int[][] grid, int row, int col, int i, int j, int[] rowIndex, int[] colIndex) {

		if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == 0) {
			return null;
		}
		colIndex[0] = Math.min(colIndex[0], j);
		colIndex[1] = Math.max(colIndex[1], j);

		rowIndex[0] = Math.min(rowIndex[0], i);
		rowIndex[1] = Math.max(rowIndex[1], i);

		getPattern(grid, row, col, i + 1, j, rowIndex, colIndex);
		getPattern(grid, row, col, i - 1, j, rowIndex, colIndex);
		getPattern(grid, row, col, i, j + 1, rowIndex, colIndex);
		getPattern(grid, row, col, i, j - 1, rowIndex, colIndex);
		
		grid[i][j] = 0;
		return getStringValue(grid, colIndex[0], rowIndex[0], colIndex[1], rowIndex[1]);
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

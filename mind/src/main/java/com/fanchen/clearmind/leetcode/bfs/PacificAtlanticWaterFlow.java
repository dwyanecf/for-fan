package com.fanchen.clearmind.leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given an m x n matrix of non-negative integers representing the height of
 * each unit cell in a continent, the "Pacific ocean" touches the left and top
 * edges of the matrix and the "Atlantic ocean" touches the right and bottom
 * edges.
 * 
 * Water can only flow in four directions (up, down, left, or right) from a cell
 * to another one with height equal or lower.
 * 
 * Find the list of grid coordinates where water can flow to both the Pacific
 * and Atlantic ocean.
 * 
 * 
 * Example:
 * 
 * Given the following 5x5 matrix:
 * 
 * 
 * Pacific ~ ~ ~ ~ ~ ~ 1 2 2 3 (5) * ~ 3 2 3 (4) (4) * ~ 2 4 (5) 3 1 * ~ (6) (7)
 * 1 4 5 * ~ (5) 1 1 2 4 * * * * * Atlantic
 * 
 * Return:
 * 
 * Note:
 * 
 * The order of returned grid coordinates does not matter. Both m and n are less
 * than 150.
 * 
 * 
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with
 * parentheses in above matrix).
 * 
 * @author fan
 *
 */
public class PacificAtlanticWaterFlow {

	public int[][] neighbours = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> list = new ArrayList<>();
		if (matrix == null || matrix.length == 0)
			return list;
		Queue<int[]> pacificQue = new LinkedList<>();
		Queue<int[]> atlanticQue = new LinkedList<>();

		int row = matrix.length;
		int col = matrix[0].length;

		boolean[][] pacific = new boolean[row][col];
		boolean[][] atlantic = new boolean[row][col];

		// set vertical default value
		for (int i = 0; i < row; i++) {
			pacificQue.offer(new int[] { i, 0 });
			pacific[i][0] = true;

			atlanticQue.offer(new int[] { i, col - 1 });
			atlantic[i][col - 1] = true;
		}

		// set horizontal default value
		for (int i = 0; i < col; i++) {
			pacificQue.offer(new int[] { 0, i });
			pacific[0][i] = true;

			atlanticQue.offer(new int[] { row - 1, i });
			atlantic[row - 1][i] = true;
		}

		bfs(matrix, pacificQue, pacific);
		bfs(matrix, atlanticQue, atlantic);

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (pacific[i][j] && atlantic[i][j]) {
					list.add(new int[] { i, j });
				}
			}
		}

		return list;
	}

	private void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] visitMap) {
		int row = matrix.length;
		int col = matrix[0].length;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int[] dir : neighbours) {
				int x = dir[0] + cur[0];
				int y = dir[1] + cur[1];

				if (x < 0 || x >= row || y < 0 || y >= col || visitMap[x][y] || matrix[cur[0]][cur[1]] > matrix[x][y])
					continue;
				visitMap[x][y] = true;
				queue.offer(new int[] { x, y });
			}
		}
	}

}

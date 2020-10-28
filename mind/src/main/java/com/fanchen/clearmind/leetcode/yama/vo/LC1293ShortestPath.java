package com.fanchen.clearmind.leetcode.yama.vo;

import java.util.LinkedList;
import java.util.Queue;

public class LC1293ShortestPath {
	int[] dirs = { 0, 1, 0, -1, 0 };

	public int shortestPath(int[][] grid, int k) {
		int m = grid.length, n = grid[0].length;
		boolean[][][] visited = new boolean[m][n][m * n];
		visited[0][0][0] = true;
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(0, 0, 0, 0));
		while (!q.isEmpty()) {
			Node top = q.poll();
			if (top.r == m - 1 && top.c == n - 1)
				return top.dist; // Found the result
			for (int i = 0; i < 4; i++) {
				int nr = top.r + dirs[i], nc = top.c + dirs[i + 1];
				if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
					int nk = top.k + grid[nr][nc]; // Number of the obstacles elimination so far
					if (nk <= k && !visited[nr][nc][nk]) {
						visited[nr][nc][nk] = true;
						q.offer(new Node(nr, nc, nk, top.dist + 1));
					}
				}
			}
		}
		return -1; // Not found
	}

	class Node {
		int r, c, k, dist;

		Node(int r, int c, int k, int dist) {
			this.r = r;
			this.c = c;
			this.k = k;
			this.dist = dist;
		}
	}
}

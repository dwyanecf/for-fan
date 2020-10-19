package com.fanchen.clearmind.leetcode.yama.OA;

public class LC547 {

	public int findCircleNum(int[][] M) {
		int count = 0;
		int n = M.length;
		int[] visited = new int[n];
		for (int i = 0; i < n; i++) {
			if (visited[i] == 0) {
				dfs(M, visited, i);
				count++;
			}
		}
		return count;

	}

	public void dfs(int[][] m, int[] visited, int i) {

		for (int j = 0; j < visited.length; j++) {
			if (m[i][j] == 1 && visited[j] == 0) {
				visited[j] = 1;
				dfs(m, visited, j);
			}
		}
	}

}

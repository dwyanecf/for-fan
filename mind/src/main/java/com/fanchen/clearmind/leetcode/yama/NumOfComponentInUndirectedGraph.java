package com.fanchen.clearmind.leetcode.yama;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumOfComponentInUndirectedGraph {
	public int countComponents(int n, int[][] edges) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(i, new ArrayList<>());
		}
		for (int[] e : edges) {
			map.get(e[0]).add(e[1]);
			map.get(e[1]).add(e[0]);
		}
		boolean[] visited = new boolean[n];
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(visited, map, i);
				ans++;
			}
		}

		return ans;

	}

	private void dfs(boolean[] visited, Map<Integer, List<Integer>> map, int i) {
		for (int point : map.get(i)) {
			if (!visited[point]) {
				visited[point] = true;
				dfs(visited, map, point);
			}
		}
	}
}

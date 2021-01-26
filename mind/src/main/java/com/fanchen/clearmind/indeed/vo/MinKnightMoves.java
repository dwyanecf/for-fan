package com.fanchen.clearmind.indeed.vo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinKnightMoves {

	private final int[][] dir = new int[][] { { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 }, { 2, 1 }, { 2, -1 },
			{ -2, 1 }, { -2, -1 } };

	public int minMoves(int targetX, int targetY, int startX, int startY, Set<String> obstacles) {
		// int[] o = { {1,2}, {3,4} };
		int res = 0;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { startX, startY });

		Set<String> visited = new HashSet<>();

		while (!q.isEmpty()) {
			// BFS
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				int x = cur[0];
				int y = cur[1];
				if (x == targetX && y == targetY) {
					return res;
				}
				for (int[] d : dir) {
					int nextX = x + d[0];
					int nextY = y + d[1];
					if (!obstacles.contains(nextX + "," + nextY) && !visited.contains(nextX + "," + nextY)) {
						q.offer(new int[] { nextX, nextY });
						visited.add(nextX + "," + nextY);
					}
				}
			}
			res++;
		}

		return -1;
	}
}

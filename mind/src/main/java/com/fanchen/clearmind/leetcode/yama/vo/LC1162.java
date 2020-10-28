package com.fanchen.clearmind.leetcode.yama.vo;

import java.util.ArrayDeque;
import java.util.Queue;

//As Far from Land as Possible
public class LC1162 {
	public int maxDistance(int[][] grid) {
		int n = grid.length, m = grid[0].length, res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1)
					continue;
				grid[i][j] = 1000; // 201 here cuz as the despription, the size won't exceed 100.
				if (i > 0)
					grid[i][j] = Math.min(grid[i][j], grid[i - 1][j] + 1);
				if (j > 0)
					grid[i][j] = Math.min(grid[i][j], grid[i][j - 1] + 1);
			}
		}

		for (int i = n - 1; i > -1; i--) {
			for (int j = m - 1; j > -1; j--) {
				if (grid[i][j] == 1)
					continue;
				if (i < n - 1)
					grid[i][j] = Math.min(grid[i][j], grid[i + 1][j] + 1);
				if (j < m - 1)
					grid[i][j] = Math.min(grid[i][j], grid[i][j + 1] + 1);
				res = Math.max(res, grid[i][j]); // update the maximum
			}
		}

		return res == 1000 ? -1 : res - 1;
	}
	
	
	
	
	
	
    int[][] directions = new int[][] {{-1, 0},{1,0},{0,-1},{0,1}};
    public int maxDistances(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)return -1;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i = 0 ; i < grid.length ; i++) {
            for(int j = 0 ; j < grid[0].length ; j++) {
                if(grid[i][j] == 1) {
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        int level = -1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0 ; i < size ; i++) {
                int[] start = queue.poll();
                int x = start[0];
                int y = start[1];
                for(int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length 
                       && !visited[newX][newY] && grid[newX][newY] == 0) {
                        visited[newX][newY] = true;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
            level++;
        }
        return level <= 0 ? -1 : level;
    }
}

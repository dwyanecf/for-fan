package com.fanchen.clearmind.indeed.vo;

import java.util.Arrays;

public class LC688KnightProbabilityInChessboard {

	int[][] moves = { { 1, 2 }, { 1, -2 }, { 2, 1 }, { 2, -1 }, { -1, 2 }, { -1, -2 }, { -2, 1 }, { -2, -1 } };

	public double knightProbability(int N, int K, int r, int c) {
		double dp[][] = new double[N][N];
		for (double[] row : dp)
			Arrays.fill(row, 1);
		for (int l = 0; l < K; l++) {
			double[][] temp = new double[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int[] move : moves) {
						int row = i + move[0];
						int col = j + move[1];
						if (isLegal(row, col, N))
							temp[i][j] += dp[row][col];
					}
				}
			}
			dp = temp;
		}
		return dp[r][c] / Math.pow(8, K);
	}

	private boolean isLegal(int r, int c, int len) {
		return r >= 0 && r < len && c >= 0 && c < len;
	}

}

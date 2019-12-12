/*
 * Copyright (C) 2019 Copart, Inc. All rights reserved.
 */
package com.fanchen.groupsolve;

import java.util.Arrays;

/**
 * @author fachen
 *
 */
public class KnightProbability {

	/**
	 * On an NxN chessboard, a knight starts at the r-th row and c-th column and
	 * attempts to make exactly K moves. The rows and columns are 0 indexed, so the
	 * top-left square is (0, 0), and the bottom-right square is (N-1, N-1).
	 * 
	 * A chess knight has 8 possible moves it can make, as illustrated below. Each
	 * move is two squares in a cardinal direction, then one square in an orthogonal
	 * direction.
	 * 
	 * Each time the knight is to move, it chooses one of eight possible moves
	 * uniformly at random (even if the piece would go off the chessboard) and moves
	 * there.
	 *
	 * The knight continues moving until it has made exactly K moves or has moved
	 * off the chessboard. Return the probability that the knight remains on the
	 * board after it has stopped moving.
	 */
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

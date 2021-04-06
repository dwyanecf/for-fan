package com.fanchen.clearmind.zillow.VO;

public class LC79WordSearch {
	public boolean exist(char[][] board, String word) {
		int row = board.length;
		int col = board[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (dfs(board, i, j, row, col, 0, word)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean dfs(char[][] board, int i, int j, int row, int col, int index, String s) {
		// TODO Auto-generated method stub

		if (index == s.length())
			return true;

		if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] != s.charAt(index)) {
			return false;
		}

		board[i][j] ^= 128;

		boolean exist = dfs(board, i + 1, j, row, col, index + 1, s) || dfs(board, i, j + 1, row, col, index + 1, s)
				|| dfs(board, i - 1, j, row, col, index + 1, s) || dfs(board, i, j - 1, row, col, index + 1, s);
		board[i][j] ^= 128;
		return exist;
	}
}

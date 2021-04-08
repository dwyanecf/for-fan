package com.fanchen.clearmind.zillow.VO;

public class Minesweeper {

	public boolean[][] visited;

	public char[][] updateBoard(char[][] board, int[] click) {
		int i = click[0];
		int j = click[1];
		if (board[i][j] == 'M') {
			board[i][j] = 'X';
			return board;
		}
		visited = new boolean[board.length][board[0].length];
		check(i, j, board);
		return board;
	}

	public void check(int i, int j, char[][] board) {
		if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && !visited[i][j] && board[i][j] != 'M') {
			int num = findMine(i - 1, j - 1, board) + findMine(i - 1, j, board) + findMine(i - 1, j + 1, board)
					+ findMine(i + 1, j - 1, board) + findMine(i + 1, j, board) + findMine(i + 1, j + 1, board)
					+ findMine(i, j + 1, board) + findMine(i, j - 1, board);
			visited[i][j] = true;
			if (num == 0) {
				board[i][j] = 'B';
				check(i + 1, j + 1, board);
				check(i + 1, j, board);
				check(i + 1, j - 1, board);
				check(i - 1, j + 1, board);
				check(i - 1, j, board);
				check(i - 1, j - 1, board);
				check(i, j + 1, board);
				check(i, j - 1, board);

			} else {
				board[i][j] = (char) ('0' + num);
			}
		}
	}

	public int findMine(int row, int col, char[][] board) {
		if (row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1)
			return 0;
		if (board[row][col] == 'M')
			return 1;
		else
			return 0;
	}
}

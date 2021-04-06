package com.fanchen.clearmind.zillow.VO;

public class Minesweeper {

	public char[][] Board;
	public boolean[][] visited;

	public char[][] updateBoard(char[][] board, int[] click) {
		int row = click[0], col = click[1];
		if (board[row][col] == 'M') {
			board[row][col] = 'X';
			return board;
		}
		Board = board;
		visited = new boolean[board.length][board[0].length];
		check(row, col);
		return Board;
	}

	public void check(int row, int col) {
		if (row >= 0 && row < Board.length && col >= 0 && col < Board[0].length && !visited[row][col]
				&& Board[row][col] != 'M') {
			int num = findMine(row - 1, col - 1) + findMine(row - 1, col) + findMine(row - 1, col + 1)
					+ findMine(row + 1, col - 1) + findMine(row + 1, col) + findMine(row + 1, col + 1)
					+ findMine(row, col + 1) + findMine(row, col - 1);
			visited[row][col] = true;
			if (num == 0) {
				Board[row][col] = 'B';
				check(row + 1, col + 1);
				check(row + 1, col);
				check(row + 1, col - 1);
				check(row - 1, col + 1);
				check(row - 1, col);
				check(row - 1, col - 1);
				check(row, col + 1);
				check(row, col - 1);

			} else {
				Board[row][col] = (char) ('0' + num);
			}
		}
	}

	public int findMine(int row, int col) {
		if (row < 0 || row > Board.length - 1 || col < 0 || col > Board[0].length - 1)
			return 0;
		if (Board[row][col] == 'M')
			return 1;
		else
			return 0;
	}
}

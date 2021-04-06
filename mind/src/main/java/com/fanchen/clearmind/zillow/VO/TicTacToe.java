package com.fanchen.clearmind.zillow.VO;

public class TicTacToe {

	public int[] rows;
	public int[] cols;
	public int diagnal;
	public int antiDiagnal;

	/** Initialize your data structure here. */
	public TicTacToe(int n) {
		rows = new int[n];
		cols = new int[n];
	}

	/**
	 * Player {player} makes a move at ({row}, {col}).
	 * 
	 * @param row    The row of the board.
	 * @param col    The column of the board.
	 * @param player The player, can be either 1 or 2.
	 * @return The current winning condition, can be either: 0: No one wins. 1:
	 *         Player 1 wins. 2: Player 2 wins.
	 */
	public int move(int row, int col, int player) {
		int score = player == 1 ? 1 : -1;
		rows[row] += score;
		cols[col] += score;
		if (col == row) {
			diagnal += score;
		}
		if (col == cols.length - 1 - row) {
			antiDiagnal += score;
		}
		int size = rows.length;
		if (Math.abs(rows[row]) == size || Math.abs(cols[col]) == size || Math.abs(antiDiagnal) == size
				|| Math.abs(diagnal) == size) {
			return player;
		}
		return 0;
	}
}

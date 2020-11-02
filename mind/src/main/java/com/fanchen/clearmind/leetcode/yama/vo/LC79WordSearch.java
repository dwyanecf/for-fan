package com.fanchen.clearmind.leetcode.yama.vo;

public class LC79WordSearch {
	public boolean exist(char[][] board, String word) {
		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (dfs(board, word, i, j, 0))
					return true;
			}
		}
		return false;
	}
    
    public boolean dfs(char[][] board, String word, int i, int j, int index){
        if(index == word.length()) return true;
        if(i<0 || j<0 || i==board.length || j==board[0].length) return false;
        if(board[i][j] != word.charAt(index)) return false;
        board[i][j] ^= 128;
        boolean exist = dfs(board, word, i+1, j, index+1) ||
            dfs(board, word, i, j+1, index+1) ||
            dfs(board, word, i-1, j, index+1) ||
            dfs(board, word, i, j-1, index+1);
        board[i][j] ^= 128;
        return exist;
    }
}

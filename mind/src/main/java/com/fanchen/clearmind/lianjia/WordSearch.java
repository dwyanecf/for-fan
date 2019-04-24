package com.fanchen.clearmind.lianjia;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, word.toCharArray(), i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] word, int i, int j, int index) {
        if (index == word.length) return true;
        if (i < 0 || j < 0 || i == board.length || j == board[i].length) return false;
        if (board[i][j] != word[index]) return false;
        board[i][j] ^= 256;
        boolean exist =
                dfs(board, word, i + 1, j, index + 1) ||
                        dfs(board, word, i - 1, j, index + 1) ||
                        dfs(board, word, i, j + 1, index + 1) ||
                        dfs(board, word, i, j - 1, index + 1);
        board[i][j] ^= 256;
        return exist;
    }
}

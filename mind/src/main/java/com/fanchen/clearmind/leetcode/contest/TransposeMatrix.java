package com.fanchen.clearmind.leetcode.contest;

/**
 * Given a matrix A, return the transpose of A.
 *
 * The transpose of a matrix is the matrix flipped over it's main diagonal,
 * switching the row and column indices of the matrix.
 *
 *
 *
 * Example 1:
 *
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[1,4,7],[2,5,8],[3,6,9]]
 * Example 2:
 *
 * Input: [[1,2,3],[4,5,6]]
 * Output: [[1,4],[2,5],[3,6]]
 */
public class TransposeMatrix {
    public int[][] transpose(int[][] A) {
        if(A == null || A.length ==0 || A[0].length ==0) return A;
        int row = A.length;
        int col = A[0].length;
        int[][] B = new int[col][row];
        for(int j = 0; j<col; j++){
            for(int i = 0; i<row;i++){
                B[j][i] = A[i][j];
            }
        }
        return B;
    }
}

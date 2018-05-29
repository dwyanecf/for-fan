package com.fanchen.clearmind.leetcode.contest;

import java.util.HashSet;
import java.util.Set;

/**
 * A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.
 * <p>
 * Given an N x N grid of integers, how many 3 x 3 "magic square" subgrids are there?  (Each subgrid is contiguous).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[4,3,8,4],
 * [9,5,1,9],
 * [2,7,6,2]]
 * Output: 1
 * Explanation:
 * The following subgrid is a 3 x 3 magic square:
 * 438
 * 951
 * 276
 * <p>
 * while this one is not:
 * 384
 * 519
 * 762
 * <p>
 * In total, there is only one magic square inside the given grid.
 * Note:
 * <p>
 * 1 <= grid.length = grid[0].length <= 10
 * 0 <= grid[i][j] <= 15
 */
public class MagicSquaresInGrid {
    public static Set<Integer> set;

    public static int numMagicSquaresInside(int[][] grid) {
        int sum = 0;
        set = new HashSet<>();
        populateSet(set);
        int row = grid.length;
        int col = grid[0].length;
        if (row < 3 || col < 3) return 0;
        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < col - 2; j++) {
                if (checker(grid[i][j], grid[i][j + 1], grid[i][j + 2],
                        grid[i + 1][j], grid[i + 1][j + 1], grid[i + 1][j + 2],
                        grid[i + 2][j], grid[i + 2][j + 1], grid[i + 2][j + 2])) {
                    sum++;
                }
            }
        }
        return sum;
    }


    public static boolean checker(int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (i5 != 5) return false;
        if (set.remove(i1) && set.remove(i2) && set.remove(i3)
                && set.remove(i4) && set.remove(i5) && set.remove(i6)
                && set.remove(i7) && set.remove(i8) && set.remove(i9)
                && (i1 + i2 + i3 == 15) && (i1 + i4 + i7 == 15)
                && (i1 + i5 + i9 == 15) && (i3 + i5 + i7 == 15)
                && (i4 + i5 + i6 == 15)
                && (i7 + i8 + i9 == 15) && (i2 + i5 + i8 == 15) && (i3 + i6 + i9 == 15))
            return true;
        else {
            set.clear();
            populateSet(set);
            return false;
        }
    }

    private static void populateSet(Set<Integer> set) {
        for (int i = 1; i <= 9; i++) {
            set.add(i);
        }
    }

    public static void main(String[] args){
      int[][] grid = {
              {4,3,8,4},
              {9,5,1,9},
              {2,7,6,2}
      };
        System.out.println(numMagicSquaresInside(grid));
    }
}

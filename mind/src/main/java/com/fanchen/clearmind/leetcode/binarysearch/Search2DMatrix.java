/*
 * Copyright (C) 2019 Copart, Inc. All rights reserved.
 */
package com.fanchen.clearmind.leetcode.binarysearch;

/**
 * @author Fan Chen
 *
 */
public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		int row = matrix.length;
		int col = matrix[0].length;

		int curR = row - 1;
		int curC = 0;

		for (; curC < col && curR >= 0;) {
			if (matrix[curR][curC] == target) {
				return true;
			} else if (matrix[curR][curC] < target) {
				curC++;
			} else {
				curR--;
			}
		}
		return false;

	}

}

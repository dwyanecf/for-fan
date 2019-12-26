/*
 * Copyright (C) 2019 Copart, Inc. All rights reserved.
 */
package com.fanchen.groupsolve;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fachen
 *
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		if (matrix == null || matrix.length == 0)
			return list;
		int l = 0;
		int t = 0;
		int b = matrix.length - 1;
		int r = matrix[0].length - 1;

		while (true) {
			for (int j = l; j <= r; j++) {
				list.add(matrix[t][j]);
			}
			t++;
			if (t > b || l > r)
				break;

			for (int i = t; i <= b; i++) {
				list.add(matrix[i][r]);
			}
			r--;
			if (l > r)
				break;

			for (int j = r; j >= l; j--) {
				list.add(matrix[b][j]);
			}
			b--;
			if (t > b)
				break;

			for (int i = b; i >= t; i--) {
				list.add(matrix[i][l]);
			}
			l++;
			if (l > r)
				break;
		}
		return list;
	}

}

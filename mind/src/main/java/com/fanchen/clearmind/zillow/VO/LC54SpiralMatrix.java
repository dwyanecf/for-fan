package com.fanchen.clearmind.zillow.VO;

import java.util.ArrayList;
import java.util.List;

public class LC54SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> list = new ArrayList<>();
		if (matrix.length < 1)
			return list;
		int left = 0;
		int right = matrix[0].length - 1;
		int top = 0;
		int down = matrix.length - 1;
		while (true) {
			for (int i = left; i <= right; i++) {
				list.add(matrix[top][i]);
			}
			top++;
			if (left > right || top > down)
				break;

			for (int i = top; i <= down; i++) {
				list.add(matrix[i][right]);
			}
			right--;
			if (left > right || top > down)
				break;

			for (int i = right; i >= left; i--) {
				list.add(matrix[down][i]);
			}
			down--;
			if (left > right || top > down)
				break;

			for (int i = down; i >= top; i--) {
				list.add(matrix[i][left]);
			}
			left++;
			if (left > right || top > down)
				break;
		}
		return list;
	}
}

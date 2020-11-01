package com.fanchen.clearmind.leetcode.yama.vo;

public class LC733FloodFill {
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if (newColor == image[sr][sc])
			return image;

		helper(image, sr, sc, image[sr][sc], newColor);
		return image;
	}

	private void helper(int[][] image, int sr, int sc, int originColor, int newColor) {
		if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != originColor) {
			return;
		}
		image[sr][sc] = newColor;
		helper(image, sr + 1, sc, originColor, newColor);
		helper(image, sr - 1, sc, originColor, newColor);
		helper(image, sr, sc + 1, originColor, newColor);
		helper(image, sr, sc - 1, originColor, newColor);

	}
}

package com.fanchen.clearmind.leetcode.DepthFirst;

/**
 *
 An image is represented by a 2-D array of integers,
 each integer representing the pixel value of the image (from 0 to 65535).

 Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill,
 and a pixel value newColor, "flood fill" the image.

 To perform a "flood fill", consider the starting pixel,
 plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel,
 plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel),
 and so on. Replace the color of all of the aforementioned pixels with the newColor.

 At the end, return the modified image.

 Example 1:
 Input:
 image = [[1,1,1],[1,1,0],[1,0,1]]
 sr = 1, sc = 1, newColor = 2
 Output: [[2,2,2],[2,2,0],[2,0,1]]
 Explanation:
 From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
 by a path of the same color as the starting pixel are colored with the new color.
 Note the bottom corner is not colored 2, because it is not 4-directionally connected
 to the starting pixel.
 Note:

 The length of image and image[0] will be in the range [1, 50].
 The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
 The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
 */
public class FloodFill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int row = image.length;
        int col = image[0].length;
        int origin = image[sr][sc];
        if(origin == newColor) return image;
        helper(image, row, col, sr, sc, newColor, origin);
        return image;
    }

    private  static void helper(int[][] image, int row, int col, int sr, int sc, int newColor, int origin) {
        if(sr <0 || sr >= row || sc <0 || sc>col || image[sr][sc]!= origin) return;
        image[sr][sc] = newColor;
        helper(image,row,col,sr-1,sc,newColor, origin);
        helper(image,row,col,sr+1,sc,newColor, origin);
        helper(image,row,col,sr,sc-1,newColor, origin);
        helper(image,row,col,sr,sc+1,newColor, origin);
    }

    public static void main(String[] args){
      int[][] image = new int[][]{{0,0,0},{0,1,1}};
      floodFill(image,1,1,1);
      for(int i=0; i<image.length;i++){
          for(int j=0;j<image[0].length;j++){
              System.out.println(image[i][j]);
          }
      }
    }
}

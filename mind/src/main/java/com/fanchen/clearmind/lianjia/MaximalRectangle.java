package com.fanchen.clearmind.lianjia;

import java.util.Arrays;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * Output: 6
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];

        Arrays.fill(left, 0);
        Arrays.fill(right, n);
        Arrays.fill(height, 0);

        for(int i = 0;i <m;i++){
            int curLeft = 0;
            int curRight= n;

            for(int j=0;j<n;j++){
                height[j] = matrix[i][j]=='1'? height[j]+1:0;
            }

            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    left[j] = Math.max(left[j], curLeft);
                }else{
                    left[j] = 0;
                    curLeft = j+1;
                }
            }

            for(int j= n-1;j>=0;j--){
                if(matrix[i][j]=='1'){
                    right[j] = Math.min(right[j], curRight);
                }else{
                    right[j] = n;
                    curRight = j;
                }
            }

            for(int j=0;j<n;j++){
                max = Math.max(max, height[j]*(right[j]-left[j]));
            }

        }
        return max;
    }
}

package com.fanchen.clearmind.concept;

public class Champagne {
    public static double champagneTower(int poured, int query_row, int query_glass) {
        double[] dp = new double[101];
        dp[0] = poured;
        for(int row=1; row<=query_row; row++){
            for(int i=row; i>=0; i--){
                dp[i] = Math.max(0.0, (dp[i]-1)/2);
                dp[i+1] += dp[i];
            }
        }
        return Math.min(dp[query_glass], 1.0);
    }

    public static void main(String[] args){
        champagneTower(4, 2, 2);
    }
}

package com.fanchen.clearmind.GroupSolve.DP.medium;

/**
 * Alex and Lee play a game with piles of stones.  There are an even number of piles arranged in a row,
 * and each pile has a positive integer number of stones piles[i].
 *
 * The objective of the game is to end with the most stones.  The total number of stones is odd, so there are no ties.
 *
 * Alex and Lee take turns, with Alex starting first.  Each turn,
 * a player takes the entire pile of stones from either the beginning or the end of the row.
 * This continues until there are no more piles left, at which point the person with the most stones wins.
 *
 * Assuming Alex and Lee play optimally, return True if and only if Alex wins the game.
 *
 * Example 1:
 *
 * Input: [5,3,4,5]
 * Output: true
 * Explanation:
 * Alex starts first, and can only take the first 5 or the last 5.
 * Say he takes the first 5, so that the row becomes [3, 4, 5].
 * If Lee takes 3, then the board is [4, 5], and Alex takes 5 to win with 10 points.
 * If Lee takes the last 5, then the board is [3, 4], and Alex takes 4 to win with 9 points.
 * This demonstrated that taking the first 5 was a winning move for Alex, so we return true.
 *
 * Note:
 *
 * 2 <= piles.length <= 500
 * piles.length is even.
 * 1 <= piles[i] <= 500
 * sum(piles) is odd.
 */
public class StoneGame {

    /**
     * dp[i][j] means the biggest number of stones you can get more than opponent picking piles in piles[i] ~ piles[j].
     * You can first pick piles[i] or piles[j].
     *
     * If you pick piles[i], your result will be piles[i] - dp[i + 1][j]
     * If you pick piles[j], your result will be piles[j] - dp[i][j - 1]
     * So we get:
     * dp[i][j] = max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1])
     * We start from smaller subarray and then we use that to calculate bigger subarray.
     * @param p
     * @return
     *
     *
     *
     * Input: [5,3,4,5,8]
     * [5
     *     3
     *       4
     *          5
                   8]

    */
    public static boolean stoneGame(int[] p) {
        int n = p.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) dp[i][i] = p[i];

        for (int d = 1; d < n; d++) {
            for (int i = 0; i < n - d; i++) {
                dp[i][i + d] = Math.max(p[i] - dp[i + 1][i + d], p[i + d] - dp[i][i + d - 1]);
            }
        }
        return dp[0][n - 1] > 0;
    }
    public static void main(String[] args){
      int[] test = new int[]{5,3,4,5,8};
        stoneGame(test);
    }
}

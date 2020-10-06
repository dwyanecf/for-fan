package com.fanchen.clearmind.leetcode.ama;

public class LC1335 {

	/**
	 * Input: jobDifficulty = [6,5,4,3,2,1], d = 2 Output: 7 Explanation: First day
	 * you can finish the first 5 jobs, total difficulty = 6. Second day you can
	 * finish the last job, total difficulty = 1. The difficulty of the schedule = 6
	 * + 1 = 7
	 * 
	 * @param jobDifficulty
	 * @param d
	 * @return
	 */
	public static int minDifficulty(int[] jobDifficulty, int d) {
		int n = jobDifficulty.length;
		if (d > n)
			return -1;
		// initialize first day's difficulty for all possibilities
		int[][] dp = new int[d + 1][n + 1];
		for (int i = 1; i <= n; i++)
			dp[1][i] = Math.max(dp[1][i - 1], jobDifficulty[i - 1]);
		// loop from the second day to the last day
		for (int i = 2; i <= d; i++) {
			// on i-th day, we finish j jobs (j is at least 2, as we should work at at least
			// 1 job per day)
			for (int j = i; j <= n; j++) {
				dp[i][j] = Integer.MAX_VALUE;
				int currMax = 0;
				// use k as the index to track the difficulty of jobs we are facing
				for (int k = j; k >= i; k--) {
					currMax = Math.max(currMax, jobDifficulty[k - 1]);
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][k - 1] + currMax);
				}
			}
		}
		return dp[d][n];
	}

	public static void main(String[] args) {
		int[] jobs = new int[] { 6, 5, 4, 3, 2, 1 };
		int d = 2;
		minDifficulty(jobs, d);
	}

}

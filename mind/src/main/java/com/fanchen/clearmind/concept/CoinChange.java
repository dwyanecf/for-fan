package com.fanchen.clearmind.concept;

public class CoinChange {
	public static int coinChange(int[] coins, int amount) {
		if (coins == null || coins.length == 0 || amount == 0)
			return 0;
		int[] dp = new int[amount + 1];
		for (int i = 1; i <= amount; i++) {
			dp[i] = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i && dp[i - coins[j]] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
				}
			}
		}
		return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
	}

	public static void main(String[] args) {
		int[] coins = new int[] { 1, 2, 5 };
		int amount = 11;
		coinChange(coins, amount);

	}
}

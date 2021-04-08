package com.fanchen.clearmind.zillow.VO;

public class Stock {
	public int maxProfit(int[] prices) {
		int max = 0;
		int cur = 0;
		for (int i = 1; i < prices.length; i++) {
			int diff = prices[i] - prices[i - 1];
			cur += diff;
			if (cur > 0) {
				max = Math.max(max, cur);
			} else {
				cur = 0;
			}

		}
		return max;
	}

	public int maxProfit2(int[] prices) {

		int max = 0;
		for (int i = 1; i < prices.length; i++) {
			int diff = prices[i] - prices[i - 1];
			if (diff > 0) {
				max += diff;
			}
		}
		return max;

	}

	public int maxProfit(int k, int[] prices) {
		int len = prices.length;
		if (k >= len / 2)
			return quickSolve(prices);

		// dp[i][j] = maximum profit from at most i transactions using prices[0..j]
		int[][] t = new int[k + 1][len];
		for (int i = 1; i <= k; i++) {
			int tmpMax = -prices[0];
			for (int j = 1; j < len; j++) {
				t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
				// tmpMax means the maximum profit of just doing at most i-1 transactions, using
				// at most first j-1 prices, and buying the stock at price[j] - this is used for
				// the next loop.
				tmpMax = Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
			}
		}
		return t[k][len - 1];
	}

	private int quickSolve(int[] prices) {
		int len = prices.length, profit = 0;
		for (int i = 1; i < len; i++)
			// as long as there is a price gap, we gain a profit.
			if (prices[i] > prices[i - 1])
				profit += prices[i] - prices[i - 1];
		return profit;
	}

}

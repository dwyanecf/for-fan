package com.fanchen.clearmind.GroupSolve.DP.easy;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */

/**
 * 1.check price[i] - prices[i-1] >0? if yes then set to max; 2.check cur >0 or
 * not, if not then set cur = 0;
 */
public class BestTimeToSellStock {
	public static int maxProfit(int[] prices) {
		int cur = 0;
		int max = 0;
		for (int i = 1; i < prices.length; i++) {
			int diff = prices[i] - prices[i - 1];
			cur += diff;
			if (cur > 0) {
				if (cur > max) {
					max = cur;
					System.out.println("Sell: " + prices[i]);
					System.out.println("Bought: " + (prices[i] - max));
				}
			} else {
				cur = 0;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		maxProfit(new int[] { 7, 1, 5, 3, 6, 4 });
	}
}

package com.fanchen.clearmind.ebay;

public class LC121BestTimeBuySellStock {
	public int maxProfit(int[] prices) {
		int max = 0;
		int cur = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			int diff = prices[i + 1] - prices[i];
			if (cur + diff < 0) {
				cur = 0;
			} else {
				cur += diff;
				max = Math.max(max, cur);
			}
		}
		return max;
	}
}

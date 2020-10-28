package com.fanchen.clearmind.leetcode.yama.vo;

public class LC121BestTimeBuyStock {
	public int maxProfit(int[] prices) {

		int max = 0;
		int cur = 0;
		for (int i = 1; i < prices.length; i++) {
			int diff = prices[i] - prices[i - 1];
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

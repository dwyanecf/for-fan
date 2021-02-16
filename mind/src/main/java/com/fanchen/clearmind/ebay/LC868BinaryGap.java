package com.fanchen.clearmind.ebay;

public class LC868BinaryGap {
	public int binaryGap(int N) {
		int res = 0;
		int d = -100;
		for (; N > 0; N /= 2, d++) {
			if (N % 2 == 1) {
				res = Math.max(res, d);
				d = 0;
			}
		}
		return res;
	}
}

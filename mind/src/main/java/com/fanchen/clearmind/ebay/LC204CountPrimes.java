package com.fanchen.clearmind.ebay;

public class LC204CountPrimes {
	public int countPrimes(int n) {
		boolean[] nonPrimeTable = new boolean[n];
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (nonPrimeTable[i])
				continue;
			count++;
			for (int time = i; time < n; time += i) {
				nonPrimeTable[time] = true;
			}
		}
		return count;
	}
}

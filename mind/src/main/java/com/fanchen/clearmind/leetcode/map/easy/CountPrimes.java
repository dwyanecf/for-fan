package com.fanchen.clearmind.leetcode.map.easy;

/**
 * Description:
 * 
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 * 
 * @author fan
 *
 */
public class CountPrimes {
	public int countPrimes(int n) {
		boolean[] primeTable = new boolean[n];
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (primeTable[i])
				continue;
			count++;
			for (int time = i; time < n; time += i) {
				primeTable[time] = true;
			}
		}
		return count;
	}
}

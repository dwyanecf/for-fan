package com.fanchen.clearmind.leetcode.yama.OA;

public class MusicPairs {

	/**
	 * Refer to
	 * https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/submissions/
	 * 
	 * @param time
	 * @return
	 */
	public int numPairsDivisibleBy60(int[] time) {
		int[] count = new int[60];
		int res = 0;
		for (int t : time) {
			int remain = t % 60;
			int left = (60 - remain) % 60;
			res += count[left];
			count[remain]++;

		}
		return res;
	}
}

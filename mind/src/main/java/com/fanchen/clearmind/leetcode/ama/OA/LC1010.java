package com.fanchen.clearmind.leetcode.ama.OA;

public class LC1010 {

	/**
	 * In a list of songs, the i-th song has a duration of time[i] seconds.
	 * 
	 * Return the number of pairs of songs for which their total duration in seconds
	 * is divisible by 60. Formally, we want the number of indices i, j such that i
	 * < j with (time[i] + time[j]) % 60 == 0.
	 * 
	 * 
	 * 
	 * 
	 * Input: [30,20,150,100,40] Output: 3 Explanation: Three pairs have a total
	 * duration divisible by 60: (time[0] = 30, time[2] = 150): total duration 180
	 * (time[1] = 20, time[3] = 100): total duration 120 (time[1] = 20, time[4] =
	 * 40): total duration 60
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

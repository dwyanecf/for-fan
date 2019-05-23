package com.fanchen.clearmind.leetcode.binarysearch;

import java.util.TreeSet;

/**
 * Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.
 * <p>
 * Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.
 * <p>
 * So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.
 * <p>
 * Note:
 * Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
 * Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
 * As long as a house is in the heaters' warm radius range, it can be warmed.
 * All the heaters follow your radius standard and the warm radius will the same.
 * Example 1:
 * Input: [1,2,3],[2]
 * Output: 1
 * Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
 * Example 2:
 * Input: [1,2,3,4],[1,4]
 * Output: 1
 * Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.
 */

/**
 * The idea is to leverage decent Arrays.binarySearch() function provided by
 * Java.
 *
 * For each house, find its position between those heaters (thus we need the
 * heaters array to be sorted). Calculate the distances between this house and
 * left heater and right heater, get a MIN value of those two values. Corner
 * cases are there is no left or right heater. Get MAX value among distances in
 * step 2. It's the answer. Time complexity: max(O(nlogn), O(mlogn)) - m is the
 * length of houses, n is the length of heaters.
 * 

Example 1:

Input: [1,2,3],[2]
Output: 1
Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
 

Example 2:

Input: [1,2,3,4],[1,4]
Output: 1
Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.
 */
public class Heaters {
	public int findRadius(int[] houses, int[] heaters) {
		TreeSet<Integer> set = new TreeSet<>();
		for (int h : heaters) {
			set.add(h);
		}
		int res = 0;
		for (int h : houses) {
			Integer lower = set.floor(h);
			Integer higher = set.ceiling(h);
			res = Math.max(res, Math.min(lower == null ? Integer.MAX_VALUE : h - lower, higher == null ? Integer.MAX_VALUE : higher - h));
		}
		return res;
	}
}

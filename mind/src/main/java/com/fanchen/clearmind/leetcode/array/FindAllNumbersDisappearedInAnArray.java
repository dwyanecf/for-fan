package com.fanchen.clearmind.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some
 * elements appear twice and others appear once.
 * 
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * 
 * Could you do it without extra space and in O(n) runtime? You may assume the
 * returned list does not count as extra space.
 * 
 * Example:
 * 
 * Input: [4,3,2,7,8,2,3,1]
 * 
 * Output: [5,6]
 * 
 * @author fan
 *
 */
public class FindAllNumbersDisappearedInAnArray {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		boolean[] table = new boolean[nums.length + 1];
		List<Integer> res = new ArrayList<>();
		int n = nums.length;
		for (int n1 : nums) {
			table[n1] = true;
		}
		for (int i = 1; i <= n; i++) {
			if (table[i] == false) {
				res.add(i);
			}
		}
		return res;
	}
}

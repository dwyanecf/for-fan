package com.fanchen.clearmind.leetcode.map;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * The set S originally contains numbers from 1 to n. But unfortunately, due to
 * the data error, one of the numbers in the set got duplicated to another
 * number in the set, which results in repetition of one number and loss of
 * another number.
 * 
 * Given an array nums representing the data status of this set after the error.
 * Your task is to firstly find the number occurs twice and then find the number
 * that is missing. Return them in the form of an array.
 * 
 * Example 1: Input: nums = [1,2,2,4] Output: [2,3]
 * 
 * @author fan
 *
 */
public class SetMatch {
	public int[] findErrorNums(int[] nums) {
		int n = nums.length;
		int[] res = new int[2];
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			set.add(i + 1);
		}
		for (int num : nums) {
			if (!set.remove(num)) {
				res[0] = num;
			}
		}
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			res[1] = it.next();
		}
		return res;
	}

}

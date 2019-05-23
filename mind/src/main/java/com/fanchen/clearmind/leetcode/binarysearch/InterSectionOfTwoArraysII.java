package com.fanchen.clearmind.leetcode.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example 1:
 * 
 * Input: nums1 = [1,2,2,1], nums2 = [2,2] Output: [2,2] 
 * 
 * Example 2:
 * 
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4] Output: [4,9] 
 * 
 * Note:
 * 
 * Each element in the result should appear as many times as it shows in both
 * arrays. The result can be in any order.
 * 
 * @author fachen
 *
 */
public class InterSectionOfTwoArraysII {
	public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int n1 : nums1) {
			map.put(n1, map.getOrDefault(n1, 0) + 1);
		}
		List<Integer> list = new ArrayList<>();
		for (int n2 : nums2) {
			if (map.containsKey(n2) && map.get(n2) > 0) {
				list.add(n2);
				map.put(n2, map.get(n2) - 1);
			}
		}
		int[] res = new int[list.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = list.get(i);
		}
		return res;
	}
}

package com.fanchen.clearmind.leetcode.map;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * 
 * Note: Each element in the result must be unique. The result can be in any
 * order.
 * 
 * @author fan
 *
 */
public class IntersectionOfTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		List<Integer> answer = new ArrayList<>();
		for (int num : nums1) {
			set.add(num);
		}
		for (int num : nums2) {
			if (set.remove(num)) {
				answer.add(num);
			}
		}
		return answer.stream().mapToInt(e -> e).toArray();
	}
}

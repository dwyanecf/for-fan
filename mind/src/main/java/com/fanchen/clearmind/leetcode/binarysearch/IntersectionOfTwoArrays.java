package com.fanchen.clearmind.leetcode.binarysearch;

import java.util.HashSet;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example 1:
 * 
 * Input: nums1 = [1,2,2,1], nums2 = [2,2] Output: [2] Example 2:
 * 
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4] Output: [9,4] Note:
 * 
 * Each element in the result must be unique. The result can be in any order.
 * 
 * @author Fan Chen
 *
 */
public class IntersectionOfTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> intersect = new HashSet<>();
		for (int n1 : nums1) {
			set1.add(n1);
		}
		for (int n2 : nums2) {
			if (set1.contains(n2)) {
				intersect.add(n2);
			}
		}
		int[] res = new int[intersect.size()];
		int i = 0;
		for (Integer n : intersect) {
			res[i++] = n;
		}
		return res;
	}
}

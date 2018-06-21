package com.fanchen.clearmind.leetcode.map.easy;

import java.util.*;
import java.util.stream.Collectors;

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
public class IntersectionOfTwoArrays2 {
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
		return   Arrays.stream(nums2).boxed().filter(i-> set.contains(i)).mapToInt(e -> e).toArray();
	}
}

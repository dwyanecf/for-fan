package com.fanchen.clearmind.lianjia;

import java.util.ArrayList;
import java.util.List;

/**
 * Input: nums = [1,2,3] Output: [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2],
 * [] ]
 */
public class Subsets {
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		backTrack(list, new ArrayList<>(), nums, 0);
		return list;
	}

	private static void backTrack(List<List<Integer>> list, List<Integer> cur, int[] nums, int index) {
		list.add(new ArrayList<>(cur));
		for (int i = index; i < nums.length; i++) {
			cur.add(nums[i]);
			backTrack(list, cur, nums, i + 1);
			cur.remove(cur.size() - 1);
		}
	}

	public static void main(String[] args) {
		subsets(new int[] { 1, 2, 3 });
	}
}

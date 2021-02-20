package com.fanchen.clearmind.ebay.medium;

import java.util.ArrayList;
import java.util.List;

public class LC78Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		helper(list, new ArrayList<>(), nums, 0);
		return list;
	}

	public void helper(List<List<Integer>> list, List<Integer> cur, int[] nums, int index) {
		list.add(new ArrayList<>(cur));
		for (int i = index; i < nums.length; i++) {
			cur.add(nums[i]);
			helper(list, cur, nums, i + 1);
			cur.remove(cur.size() - 1);
		}
	}
}

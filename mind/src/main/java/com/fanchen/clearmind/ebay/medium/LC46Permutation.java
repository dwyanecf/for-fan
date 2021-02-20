package com.fanchen.clearmind.ebay.medium;

import java.util.ArrayList;
import java.util.List;

public class LC46Permutation {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		helper(nums, list, new ArrayList<>());
		return list;
	}

	private void helper(int[] nums, List<List<Integer>> list, List<Integer> cur) {
		if (cur.size() == nums.length) {
			list.add(new ArrayList<>(cur));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (cur.contains(nums[i])) {
				continue;
			} else {
				cur.add(nums[i]);
			}
			helper(nums, list, cur);
			cur.remove(cur.size() - 1);
		}
	}
}

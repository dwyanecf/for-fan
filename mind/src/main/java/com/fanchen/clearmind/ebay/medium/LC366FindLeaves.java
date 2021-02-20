package com.fanchen.clearmind.ebay.medium;

import java.util.ArrayList;
import java.util.List;

import com.fanchen.clearmind.concept.TreeNode;

public class LC366FindLeaves {
	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		helper(root, list);
		return list;
	}

	private int helper(TreeNode root, List<List<Integer>> list) {
		if (root == null)
			return -1;
		int level = 1 + Math.max(helper(root.left, list), helper(root.right, list));
		if (level >= list.size()) {
			list.add(new ArrayList<>());
		}
		list.get(level).add(root.val);
		return level;
	}
}

package com.fanchen.clearmind.leetcode.yama.vo;

import java.util.ArrayList;
import java.util.List;

import com.fanchen.clearmind.concept.TreeNode;

public class LC103BSTZigzag {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		helper(list, root, 0);
		return list;

	}

	private void helper(List<List<Integer>> list, TreeNode root, int i) {

		if (root == null)
			return;
		if (list.size() == i) {
			list.add(new ArrayList<>());
		}
		if (i % 2 == 0) {
			list.get(i).add(root.val);
		} else {
			list.get(i).add(0, root.val);
		}
		helper(list, root.left, i + 1);
		helper(list, root.right, i + 1);
	}

}

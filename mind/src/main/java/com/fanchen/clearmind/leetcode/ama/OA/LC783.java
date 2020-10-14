package com.fanchen.clearmind.leetcode.ama.OA;

import com.fanchen.clearmind.concept.TreeNode;

public class LC783 {

	Integer min = Integer.MAX_VALUE;
	Integer previousNodeValue = null;

	public int minDiffInBST(TreeNode root) {
		checkout(root);
		return min;
	}

	public void checkout(TreeNode node) {
		if (node == null)
			return;
		checkout(node.left);
		if (previousNodeValue != null) {
			min = Math.min(min, node.val - previousNodeValue);
		}
		previousNodeValue = node.val;
		checkout(node.right);

	}
}

/*
 * Copyright (C) 2019 Copart, Inc. All rights reserved.
 */
package com.fanchen.clearmind.leetcode.tree;

import com.fanchen.clearmind.concept.TreeNode;

/**
 * @author Fan Chen
 *
 */
public class BinaryTreeMaximumPathSum {
	
	public int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		helper(root);
		return max;
	}

	/**
	 * @param root
	 */
	private int helper(TreeNode root) {
		if (root == null)
			return 0;
		int left = Math.max(helper(root.left), 0);
		int right = Math.max(0, helper(root.right));
		max = Math.max(max, root.val + left + right);
		return root.val + Math.max(left, right);

	}
	
}

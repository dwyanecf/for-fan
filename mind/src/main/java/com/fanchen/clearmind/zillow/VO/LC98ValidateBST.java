package com.fanchen.clearmind.zillow.VO;

import com.fanchen.clearmind.concept.TreeNode;

public class LC98ValidateBST {
	public boolean isValidBST(TreeNode root) {
		return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
	}

	private boolean helper(TreeNode root, long maxValue, long minValue) {
		if (root == null)
			return true;
		if (root.val >= maxValue || root.val <= minValue)
			return false;
		return helper(root.left, root.val, minValue) && helper(root.right, maxValue, root.val);
	}
}

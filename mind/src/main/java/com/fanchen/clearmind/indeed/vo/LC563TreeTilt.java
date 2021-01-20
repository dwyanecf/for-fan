package com.fanchen.clearmind.indeed.vo;

import com.fanchen.clearmind.concept.TreeNode;

public class LC563TreeTilt {
	public int findTilt(TreeNode root) {
		int[] res = new int[1];
		helper(root, res);
		return res[0];

	}

	private int helper(TreeNode root, int[] res) {
		if (root == null)
			return 0;
		int leftSum = helper(root.left, res);
		int rightSum = helper(root.right, res);
		res[0] += Math.abs(leftSum - rightSum);
		return root.val + leftSum + rightSum;
	}
}

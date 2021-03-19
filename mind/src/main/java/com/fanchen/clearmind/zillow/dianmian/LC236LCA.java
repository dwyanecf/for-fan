package com.fanchen.clearmind.zillow.dianmian;

import com.fanchen.clearmind.concept.TreeNode;

public class LC236LCA {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == p || root == q || root == null)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left == null)
			return right;
		else if (right == null)
			return left;
		else
			return root;

	}
}

/*
 * Copyright (C) 2019 Copart, Inc. All rights reserved.
 */
package Tree;

import com.fanchen.clearmind.concept.TreeNode;

/**
 * @author Fan Chen
 *
 */

/**
 * Invert a binary tree.
	
	Example:
	
	Input:
	
	     4
	   /   \
	  2     7
	 / \   / \
	1   3 6   9
	Output:
	
	     4
	   /   \
	  7     2
	 / \   / \
	9   6 3   1
	Trivia:
	This problem was inspired by this original tweet by Max Howell:
	
	Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
 * @author Fan Chen
 *
 */
public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;
		if (root.left != null || root.right != null) {
			TreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
		invertTree(root.left);
		invertTree(root.right);

		return root;
	}
}

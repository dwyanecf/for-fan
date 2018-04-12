package com.fanchen.clearmind.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import com.fanchen.clearmind.TreeNode;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * For example:
	Given binary tree [1,null,2,3],
	   1
	    \
	     2
	    /
	   3
	return [1,3,2].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * @author fan
 *
 */
public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		helper(root, list);
		return list;
	}

	private void helper(TreeNode root, List<Integer> list) {
		if (root != null) {
			if (root.left != null) {
				helper(root.left, list);
			}
			list.add(root.val);
			if (root.right != null) {
				helper(root.right, list);
			}
		}
	}

	

}

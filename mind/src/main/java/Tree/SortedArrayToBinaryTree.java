/*
 * Copyright (C) 2019 Copart, Inc. All rights reserved.
 */
package Tree;

import com.fanchen.clearmind.concept.TreeNode;

/**
 * @author Fan Chen
 *
 *
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 */
public class SortedArrayToBinaryTree {
	public TreeNode sortedArrayToBST(int[] nums) {
		return helper(nums, 0, nums.length);
	}

	public TreeNode helper(int[] nums, int l, int r) {
		if (l >= r)
			return null;
		int mid = l + (r - l) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = helper(nums, l, mid);
		node.right = helper(nums, mid + 1, r);
		return node;
	}
}

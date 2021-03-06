/*
 * Copyright (C) 2019 Copart, Inc. All rights reserved.
 */
package Tree;

import com.fanchen.clearmind.concept.TreeNode;

/**
 * @author Fan Chen
 *
 *
 *
Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
 */
public class MaximumBinaryTree {
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;
		return helper(nums, 0, nums.length - 1);

	}

	/**
	 * @param nums
	 * @param i
	 * @param j
	 * @return
	 */
	private TreeNode helper(int[] nums, int lo, int hi) {
		if (lo > hi)
			return null;
		int cur = getMaxIndex(nums, lo, hi);
		if (cur != -1) {
			TreeNode node = new TreeNode(nums[cur]);
			node.left = helper(nums, lo, cur - 1);
			node.right = helper(nums, cur + 1, hi);
			return node;
		}
		return null;
	}

	/**
	 * @param nums
	 * @return
	 */
	private int getMaxIndex(int[] nums, int lo, int hi) {
		if (lo > hi) {
			return -1;
		}
		if (lo == hi)
			return lo;

		int index = lo;
		int max = nums[lo];
		for (int i = lo + 1; i <= hi; i++) {
			if (nums[i] > max) {
				max = nums[i];
				index = i;
			}
		}

		return index;
	}

	public static void main(String[] args) {
		// [3,2,1,6,0,5]

		MaximumBinaryTree ob = new MaximumBinaryTree();
		int[] res = new int[] { 3, 2, 1, 6, 0, 5 };
		ob.constructMaximumBinaryTree(res);
	}
}

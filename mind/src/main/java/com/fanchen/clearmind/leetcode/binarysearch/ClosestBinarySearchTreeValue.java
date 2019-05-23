package com.fanchen.clearmind.leetcode.binarysearch;

import com.fanchen.clearmind.concept.TreeNode;

/**
 * Given a non-empty binary search tree and a target value, find the value in
 * the BST that is closest to the target.
 * 
 * Note:
 * 
 * Given target value is a floating point. You are guaranteed to have only one
 * unique value in the BST that is closest to the target. Example:
 * 
 * Input: root = [4,2,5,1,3], target = 3.714286
 * 
 * 4 / \ 2 5 / \ 1 3
 * 
 * Output: 4
 * 
 * @author fachen
 *
 */
public class ClosestBinarySearchTreeValue {
	public int closestValue(TreeNode root, double target) {
		int res = root.val;
		while (root != null) {
			if (Math.abs(root.val - target) < 1e-7) {
				return root.val;
			}
			if (Math.abs(root.val - target) < Math.abs(res - target)) {
				res = root.val;
			}
			root = root.val < target ? root.right : root.left;
		}
		return res;
	}

}

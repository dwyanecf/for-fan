package com.fanchen.clearmind.leetcode.binarysearch;

import com.fanchen.clearmind.concept.TreeNode;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth
 * smallest element in it.
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * 
 * Example 1:
 * 
 * Input: root = [3,1,4,null,2], k = 1 3 / \ 1 4 \ 2 Output: 1 Example 2:
 * 
 * Input: root = [5,3,6,2,4,null,null,1], k = 3 5 / \ 3 6 / \ 2 4 / 1 Output: 3
 * Follow up: What if the BST is modified (insert/delete operations) often and
 * you need to find the kth smallest frequently? How would you optimize the
 * kthSmallest routine?
 * 
 * @author fachen
 *
 */
public class KthSmallestElementinaBST {
	public int kthSmallest(TreeNode root, int k) {
		int leftChildrenNum = countChildren(root.left);
		if (k <= leftChildrenNum) {
			return kthSmallest(root.left, k);
		} else if (k > leftChildrenNum + 1) {
			return kthSmallest(root.right, k - (leftChildrenNum + 1));
		} else {
			return root.val;
		}
	}

	public static int countChildren(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + countChildren(root.left) + countChildren(root.right);
	}
}

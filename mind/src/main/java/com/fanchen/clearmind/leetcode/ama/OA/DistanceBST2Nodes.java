package com.fanchen.clearmind.leetcode.ama.OA;

import com.fanchen.clearmind.concept.TreeNode;

public class DistanceBST2Nodes {
	public int bstDistance(TreeNode root, int node1, int node2) {
		if (root == null)
			return -1;
		TreeNode lca = lca(root, node1, node2);
		return getDistance(lca, node1) + getDistance(lca, node2);
	}

	private int getDistance(TreeNode ancestor, int target) {
		if (ancestor.val == target)
			return 0;
		TreeNode node = ancestor.left;
		if (target > ancestor.val) {
			node = ancestor.right;
		}
		return 1 + getDistance(node, target);
	}

	private TreeNode lca(TreeNode root, int node1, int node2) {
		while (true) {
			if (root.val > node1 && root.val > node2) {
				root = root.left;
			} else if (root.val < node1 && root.val < node2) {
				root = root.right;
			} else {
				return root;
			}
		}
	}

	
	// construct BST from a sorted array
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null)
			return null;
		return helper(0, nums.length, nums);
	}

	public TreeNode helper(int lo, int hi, int[] nums) {
		if (lo >= hi)
			return null;
		int mid = lo + (hi - lo) / 2;
		TreeNode cur = new TreeNode(nums[mid]);
		cur.left = helper(lo, mid, nums);
		cur.right = helper(mid + 1, hi, nums);
		return cur;
	}
}

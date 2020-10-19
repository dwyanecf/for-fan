package com.fanchen.clearmind.leetcode.yama;

import java.util.ArrayList;
import java.util.List;

import com.fanchen.clearmind.concept.TreeNode;

public class MaximumWidthBinaryTree {
	/**
	 * Given a binary tree, write a function to get the maximum width of the given
	 * tree. The width of a tree is the maximum width among all levels. The binary
	 * tree has the same structure as a full binary tree, but some nodes are null.
	 * 
	 * The width of one level is defined as the length between the end-nodes (the
	 * leftmost and right most non-null nodes in the level, where the null nodes
	 * between the end-nodes are also counted into the length calculation.
	 * 
	 * @param root
	 * @return
	 */

//	public int widthOfBinaryTree(TreeNode root) {
//		List<Integer> lefts = new ArrayList<Integer>(); // left most nodes at each level;
//		int[] res = new int[1]; // max width
//		dfs(root, 1, 0, lefts, res);
//		return res[0];
//	}
//
//	private void dfs(TreeNode node, int id, int depth, List<Integer> lefts, int[] res) {
//		if (node == null)
//			return;
//		if (depth >= lefts.size())
//			lefts.add(id); // add left most node
//		res[0] = Integer.max(res[0], id + 1 - lefts.get(depth));
//		dfs(node.left, id * 2, depth + 1, lefts, res);
//		dfs(node.right, id * 2 + 1, depth + 1, lefts, res);
//	}
	public int widthOfBinaryTree(TreeNode root) {
		int[] max = new int[1];
		List<Integer> lefts = new ArrayList<>();
		helper(lefts, max, 1, 0, root);
		return max[0];
	}

	private void helper(List<Integer> lefts, int[] max, int index, int deep, TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		if (deep >= lefts.size()) {
			lefts.add(index);
		}
		max[0] = Math.max(max[0], index + 1 - lefts.get(deep));
		helper(lefts, max, index * 2, deep + 1, root.left);
		helper(lefts, max, index * 2 + 1, deep + 1, root.right);
	}

}

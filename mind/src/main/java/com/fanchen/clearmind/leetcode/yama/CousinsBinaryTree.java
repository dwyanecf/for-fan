package com.fanchen.clearmind.leetcode.yama;

import java.util.LinkedList;
import java.util.Queue;

import com.fanchen.clearmind.concept.TreeNode;

public class CousinsBinaryTree {

	/**
	 * In a binary tree, the root node is at depth 0, and children of each depth k
	 * node are at depth k+1.
	 * 
	 * Two nodes of a binary tree are cousins if they have the same depth, but have
	 * different parents.
	 * 
	 * We are given the root of a binary tree with unique values, and the values x
	 * and y of two different nodes in the tree.
	 * 
	 * Return true if and only if the nodes corresponding to the values x and y are
	 * cousins.
	 */
	public boolean isCousins(TreeNode root, int x, int y) {

		if (root == null)
			return false;
		Queue<TreeNode> q = new LinkedList<>();

		q.offer(root);

		while (!q.isEmpty()) {
			int size = q.size();
			boolean isX = false;
			boolean isY = false;
			for (int i = 0; i < size; i++) {
				TreeNode cur = q.poll();
				if (cur.val == x)
					isX = true;
				if (cur.val == y)
					isY = true;
				if (cur.left != null && cur.right != null) {
					if(cur.left.val == x && cur.right.val == y) return false;
					if(cur.left.val == y && cur.right.val == x) return false;
				}
				if(cur.left!=null) q.offer(cur.left);
				if(cur.right!=null) q.offer(cur.right);
				if(isX && isY) return true;
			}
		}

		return false;

	}
}

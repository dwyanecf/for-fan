package com.fanchen.clearmind.leetcode.yama;

import java.util.ArrayList;
import java.util.List;

import com.fanchen.clearmind.concept.TreeNode;

public class BoundaryBinaryTree {
	List<Integer> list;

	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		list = new ArrayList<>();
		if (root == null)
			return list;
		list.add(root.val);
		addLeft(root.left);
		addLeave(root.left);
		addLeave(root.right);
		addRight(root.right);
		return list;
	}

	public void addLeft(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return;
		list.add(root.val);
		if (root.left != null) {
			addLeft(root.left);
		} else {
			addLeft(root.right);
		}
	}

	public void addRight(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return;
		if (root.right != null) {
			addRight(root.right);
		} else {
			addRight(root.left);
		}
		list.add(root.val);
	}

	public void addLeave(TreeNode root) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			list.add(root.val);
			return;
		}
		addLeave(root.left);
		addLeave(root.right);
	}
}

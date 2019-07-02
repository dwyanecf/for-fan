package com.fanchen.clearmind.leetcode.ama;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.fanchen.clearmind.concept.TreeNode;

public class BinaryTreeLevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				temp.add(node.val);
				if (node.left != null)
					q.offer(node.left);
				if (node.right != null)
					q.offer(node.right);
			}
			list.add(temp);
		}
		return list;
	}
}

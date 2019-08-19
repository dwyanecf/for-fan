/*
 * Copyright (C) 2019 Copart, Inc. All rights reserved.
 */
package Tree;

import java.util.Stack;

import com.fanchen.clearmind.concept.TreeNode;

/**
 * @author fachen
 *
 *
 *         
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

    7
   / \
  3  15
    /  \
   9   20
   
 * 
 */
public class BSTIterator {
	Stack<TreeNode> stack;

	public BSTIterator(TreeNode root) {
		stack = new Stack<>();
		pushNode(root);
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode node = stack.pop();
		pushNode(node.right);
		return node.val;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public void pushNode(TreeNode root) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}
}

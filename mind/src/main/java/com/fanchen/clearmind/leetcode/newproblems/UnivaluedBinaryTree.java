package com.fanchen.clearmind.leetcode.newproblems;

import com.fanchen.clearmind.concept.TreeNode;

/**
 * A binary tree is univalued if every node in the tree has the same value.
 * <p>
 * Return true if and only if the given tree is univalued.
 */
public class UnivaluedBinaryTree {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        return helper(root, root.val);
    }

    private boolean helper(TreeNode root, int value) {
        if (root != null) {
            if (root.val != value) {
                return false;
            } else {
                return helper(root.left, value) && helper(root.right, value);
            }
        }
        return true;
    }

}

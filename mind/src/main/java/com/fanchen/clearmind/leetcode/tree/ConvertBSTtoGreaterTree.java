package com.fanchen.clearmind.leetcode.tree;

import com.fanchen.clearmind.concept.TreeNode;

/**
 * Given a Binary Search Tree (BST),
 * convert it to a Greater Tree such that every key of the original BST is changed to
 * the original key plus sum of all keys greater than the original key in BST.
 *
 * Example:
 *
 * Input: The root of a Binary Search Tree like this:
 *               5
 *             /   \
 *            2     13
 *
 * Output: The root of a Greater Tree like this:
 *              18
 *             /   \
 *           20     13
 */
public class ConvertBSTtoGreaterTree {
    int sum =0;
    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }

    private void helper(TreeNode node) {
        if(node == null) return;
        helper(node.right);
        node.val += sum;
        sum = node.val;
        helper(node.left);
    }
}

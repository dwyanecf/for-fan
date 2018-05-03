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

    public TreeNode convertBST(TreeNode root) {
        int[] res = new int[1];
        helper(root, res);
        return root;
    }

    public int helper(TreeNode node, int[] res) {
        if (node == null) return res[0];
        node.val += helper(node.right, res);
        res[0] = node.val;
        return helper(node.left, res);
    }
}

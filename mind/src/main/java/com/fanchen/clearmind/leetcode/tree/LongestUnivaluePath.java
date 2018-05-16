package com.fanchen.clearmind.leetcode.tree;

import com.fanchen.clearmind.concept.TreeNode;

/**
 * Given a binary tree, find the length of the longest path where each node in the path has the same value.
 * This path may or may not pass through the root.
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 *
 * Example 1:
 *
 * Input:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * Output:
 *
 * 2
 * Example 2:
 *
 * Input:
 *
 *                1
 *              /   \
 *             4     5
 *            /  \   \
 *           4(0) 4(0) 5(0)
 * Output:
 *
 * 2
 * Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
 */
public class LongestUnivaluePath {
    public int longestUnivaluePath(TreeNode root) {
        int[] res = new int[1];
        helper(root, res);
        return res[0];
    }

    private int helper(TreeNode node, int[] res) {
        if (node == null) return 0;
        //从根部开始遍历
        int left = node.left == null ? 0 : helper(node.left, res);
        int right = node.right == null ? 0 : helper(node.right, res);
        int leftRes = node.left != null && node.val == node.left.val ? left + 1 : 0;
        int rightRes = node.right != null && node.val == node.right.val ? right + 1 : 0;
        res[0] = Math.max(res[0], leftRes + rightRes);
        return Math.max(leftRes, rightRes);
    }

}

package com.fanchen.clearmind.leetcode.tree;

import com.fanchen.clearmind.concept.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class SumofLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null)
                sum = sum + root.left.val;
        }
        return sum + sumOfLeftLeaves(root.right) + sumOfLeftLeaves(root.left);
    }

    public int sumOfLeftLeave(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < q.size(); i++) {
                TreeNode n = q.poll();
                if (n.left != null) {
                    q.offer(n.left);
                    if (n.left.left == null && n.left.right == null)
                        sum = sum + n.left.val;
                }
                if (n.right != null) {
                    q.offer(n.right);
                }

            }
        }
        return sum;
    }

}

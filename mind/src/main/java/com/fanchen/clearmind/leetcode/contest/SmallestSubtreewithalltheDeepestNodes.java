package com.fanchen.clearmind.leetcode.contest;

import com.fanchen.clearmind.concept.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary tree rooted at root, the depth of each node is the shortest distance to the root.
 *
 * A node is deepest if it has the largest depth possible.
 *
 * Return the node with the largest depth such that it contains all the deepest nodes in it's subtree.
 */
public class SmallestSubtreewithalltheDeepestNodes {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return root;
        }
        Map<TreeNode, Integer> map = new HashMap<>();
        return helper(root, map, 1);
    }

    private TreeNode helper(TreeNode root, Map<TreeNode, Integer> map, int depth) {
        if (root.left == null && root.right == null) {
            map.put(root, depth);
            return root;
        }
        if (root.left == null) {
            return helper(root.right, map, depth + 1);
        }
        if (root.right == null) {
            return helper(root.left, map, depth + 1);
        }
        TreeNode leftResult = helper(root.left, map, depth + 1);
        TreeNode rightResult = helper(root.right, map, depth + 1);
        if (map.get(leftResult) == map.get(rightResult)) {
            map.put(root, map.get(leftResult));
            return root;
        }
        return map.get(leftResult) > map.get(rightResult) ? leftResult : rightResult;
    }
}

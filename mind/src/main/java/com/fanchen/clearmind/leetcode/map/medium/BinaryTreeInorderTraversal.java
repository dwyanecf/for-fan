package com.fanchen.clearmind.leetcode.map.medium;

import com.fanchen.clearmind.concept.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left != null) helper(root.left, list);
        list.add(root.val);
        if (root.right != null) helper(root.right, list);
    }
}

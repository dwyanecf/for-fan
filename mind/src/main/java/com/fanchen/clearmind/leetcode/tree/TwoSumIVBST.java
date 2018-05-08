package com.fanchen.clearmind.leetcode.tree;

import com.fanchen.clearmind.concept.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a Binary Search Tree and a target number,
 * return true if there exist two elements in the BST such that their sum is equal to the given target.
 *
 * Example 1:
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * Output: True
 * Example 2:
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * Output: False
 */
public class TwoSumIVBST {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        convertToString(root, list);
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            int sum =list.get(l) + list.get(r);
            if (sum == k) return true;
            if (sum < k) {
                l++;
            } else {
                r--;
            }
        }
        return false;
    }

    private void convertToString(TreeNode root, List<Integer> sb) {
        if (root == null) return;
        convertToString(root.left, sb);
        sb.add(root.val);
        convertToString(root.right, sb);
    }

}

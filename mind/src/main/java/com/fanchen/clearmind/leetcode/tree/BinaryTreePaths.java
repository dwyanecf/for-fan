package com.fanchen.clearmind.leetcode.tree;

import com.fanchen.clearmind.concept.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 *
 * For example, given the following binary tree:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * All root-to-leaf paths are:
 *
 * ["1->2->5", "1->3"]
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        helper(list, "", root);
        return list;
    }

    private void helper(List<String> list, String sb, TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null){
            list.add( sb+root.val);
            return;
        }
        helper(list, sb+root.val+"->",root.left);
        helper(list, sb+root.val+"->",root.right);
    }
}

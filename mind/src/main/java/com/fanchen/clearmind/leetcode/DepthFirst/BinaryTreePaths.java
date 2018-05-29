package com.fanchen.clearmind.leetcode.DepthFirst;

import com.fanchen.clearmind.concept.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        helper(root, list, "");
        return list;

    }

    private void helper(TreeNode root, List<String> list, String cur) {
        if(root.left == null && root.right ==null){
            list.add ( cur+ root.val);
            return;
        }
        helper(root.left,list,cur+root.val+"->");
        helper(root.right,list,cur+root.val+"->");
    }
}

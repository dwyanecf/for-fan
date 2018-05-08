package com.fanchen.clearmind.leetcode.tree;

import com.fanchen.clearmind.concept.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary search tree (BST) with duplicates,
 * find all the mode(s) (the most frequently occurred element) in the given BST.
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * For example:
 * Given BST [1,null,2,2],
 *    1
 *     \
 *      2
 *     /
 *    2
 * return [2].
 *
 * Note: If a tree has more than one mode, you can return them in any order.
 *
 * Follow up: Could you do that without using any extra space?
 * (Assume that the implicit stack space incurred due to recursion does not count).
 *
 */
public class FindModeinBinarySearchTree {
    TreeNode preNode = null;
    int count = 1;
    int max = 0;
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[0];
        List<Integer> list = new ArrayList<Integer>();
        helper(list, root);
        int[] res = new int[list.size()];
        for(int i=0;i<res.length;i++) res[i] = list.get(i);
        return res;
    }

    private void helper(List<Integer> list, TreeNode root) {
        if(root == null) return;
        helper(list, root.left);

        if(preNode !=null){
            if(preNode.val == root.val){
                count++;
            }else{
                count=1;
            }
        }
        if(count > max){
            max = count;
            list.clear();
            list.add(root.val);
        }else if(count == max){
            list.add(root.val);
        }
        preNode = root;
        helper(list, root.right);
    }

}

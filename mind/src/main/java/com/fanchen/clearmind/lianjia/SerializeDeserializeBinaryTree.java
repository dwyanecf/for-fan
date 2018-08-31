package com.fanchen.clearmind.lianjia;

import com.fanchen.clearmind.concept.TreeNode;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits
 * so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree.
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string
 * and this string can be deserialized to the original tree structure.
 *
 * Example:
 *
 * You may serialize the following tree:
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * as "[1,2,3,null,null,4,5]"
 * Clarification: The above format is the same as how LeetCode serializes a binary tree.
 * You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 *
 * Note: Do not use class member/global/static variables to store states.
 * Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeDeserializeBinaryTree {

    public static final String nullToken = "#";
    public static final String splitToken = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(sb, root);
        return sb.toString();
    }

    public void helper(StringBuilder sb, TreeNode root) {
        if (root == null) {
            sb.append(nullToken).append(splitToken);
        } else {
            sb.append(root.val).append(splitToken);
            helper(sb, root.left);
            helper(sb, root.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] toks = data.split(splitToken);
        int[] index = new int[]{0};
        return helper2(toks, index);
    }

    public TreeNode helper2(String[] toks, int[] index) {
        if (index[0] == toks.length) return null;
        String cur = toks[index[0]++];
        if (cur.equals(nullToken)) return null;
        TreeNode node = new TreeNode(Integer.valueOf(cur));
        node.left = helper2(toks, index);
        node.right = helper2(toks, index);
        return node;
    }
}

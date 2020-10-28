package com.fanchen.clearmind.leetcode.yama.vo;

import com.fanchen.clearmind.concept.TreeNode;

public class LC297SerializeBST {


	private final static String splitToken = ",";
	private final static String nullToken = "#";

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		serializeHelper(sb, root);
		return sb.toString();
	}

	private void serializeHelper(StringBuilder sb, TreeNode root) {
		if (root == null) {
			sb.append(nullToken).append(splitToken);
		} else {
			sb.append(root.val).append(splitToken);
			serializeHelper(sb, root.left);
			serializeHelper(sb, root.right);
		}
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] tok = data.split(splitToken);
		int[] index = new int[1];
		return deserializeHelper(tok, index);
	}

	public TreeNode deserializeHelper(String[] nodes, int[] index) {

		if (index[0] == nodes.length) {
			return null;
		}
		String curStr = nodes[index[0]++];
		if (curStr.equals("#")) {
			return null;
		}
		TreeNode cur = new TreeNode(Integer.parseInt(curStr));
		cur.left = deserializeHelper(nodes, index);
		cur.right = deserializeHelper(nodes, index);
		return cur;
	}

}

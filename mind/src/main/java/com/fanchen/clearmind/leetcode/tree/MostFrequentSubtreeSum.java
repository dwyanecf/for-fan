package com.fanchen.clearmind.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fanchen.clearmind.concept.TreeNode;

/**
 * Given the root of a tree, you are asked to find the most frequent subtree
 * sum. The subtree sum of a node is defined as the sum of all the node values
 * formed by the subtree rooted at that node (including the node itself). So
 * what is the most frequent subtree sum value? If there is a tie, return all
 * the values with the highest frequency in any order. Examples 1 Input:
 * 
 * 5 / \ 2 -3 return [2, -3, 4], since all the values happen only once, return
 * all of them in any order. Examples 2 Input:
 * 
 * 5 / \ 2 -5 return [2], since 2 happens twice, however -5 only occur once.
 * Note: You may assume the sum of values in any subtree is in the range of
 * 32-bit signed integer.
 * 
 * @author fan
 *
 */
public class MostFrequentSubtreeSum {

	Map<Integer, Integer> sumToCount;
	int max = 0;

	public int[] findFrequentTreeSum(TreeNode root) {
		postOrder(root);
		List<Integer> list = new ArrayList<>();
		for (Integer key : sumToCount.keySet()) {
			if (sumToCount.get(key) == max) {
				list.add(key);
			}
		}
		int[] res = new int[list.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = list.get(i);
		}
		return res;
	}

	private int postOrder(TreeNode root) {
		if (root == null)
			return 0;
		int left = postOrder(root.left);
		int right = postOrder(root.right);
		int sum = left + right + root.val;
		int count = sumToCount.getOrDefault(sum, 0) + 1;
		sumToCount.put(sum, count);
		max = Math.max(max, sum);
		return sum;
	}

}

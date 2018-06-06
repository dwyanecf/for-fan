package com.fanchen.clearmind.leetcode.map.medium;

import com.fanchen.clearmind.concept.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given the root of a tree, you are asked to find the most frequent subtree sum.
 * The subtree sum of a node is defined as the sum of all the node values formed by
 * the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value?
 * If there is a tie, return all the values with the highest frequency in any order.
 *
 * Examples 1
 * Input:
 *
 *   5
 *  /  \
 * 2   -3
 * return [2, -3, 4], since all the values happen only once, return all of them in any order.
 * Examples 2
 * Input:
 *
 *   5
 *  /  \
 * 2   -5
 * return [2], since 2 happens twice, however -5 only occur once.
 * Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 */
public class MostFrequentSubtreeSum {
    public int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        traverse(root, map);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) list.add(entry.getKey());
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) res[i] = list.get(i);
        return res;

    }

    public int traverse(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return 0;
        int left = traverse(root.left, map);
        int right = traverse(root.right, map);
        int sum = root.val + left + right;
        map.put(sum, map.getOrDefault(sum,0) + 1);
        max = Math.max(max, map.get(sum));
        return sum;
    }
}

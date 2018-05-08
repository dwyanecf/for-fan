package com.fanchen.clearmind.leetcode.tree;

import com.fanchen.clearmind.concept.TreeNode;

import java.util.*;

/**
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * Example 1:
 * Input:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 * Note:
 * The range of node's value is in the range of 32-bit signed integer.
 */
public class AverageofLevelsinBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            double sum =0.0;
            int count =0;
            for(int i =0;i<size;i++){
                TreeNode node = q.poll();
                sum += node.val;
                count++;
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            res.add(sum/count);
        }
        return res;
    }








    public List<Double> averageOfLevelss(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) return res;
        Map<Integer, Integer> map = new HashMap<>();
        int height = getHeight(root);
        for (int i = 0; i < height; i++) {
            res.add(0.0);
        }
        traverse(map, res, root, 0);
        for (int i = 0; i < res.size(); i++) {
            res.set(i, res.get(i) / map.get(i));
        }
        return res;
    }

    private void traverse(Map<Integer, Integer> map, List<Double> res, TreeNode root, int level) {
        if (root == null) return;
        map.put(level, map.getOrDefault(level, 0) + 1);
        res.set(level, res.get(level) + root.val);
        traverse(map, res, root.left, level+1);
        traverse(map, res, root.right, level+1);
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        else return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}

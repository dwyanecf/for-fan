package com.fanchen.clearmind.indeed.vo;

import java.util.ArrayList;
import java.util.List;

class Edge {
	TreeNode node; // 表示这个edge的尾巴指向哪里。
	int cost;

	public Edge(TreeNode n, int cost) {
		this.node = n;
		this.cost = cost;
	}
}

class TreeNode {
	List<Edge> edges; // 表示从这个头出发的所有edge

	public TreeNode() {
		this.edges = new ArrayList<>();
	}
}

public class RootToLeaf {

	int minCost = Integer.MAX_VALUE;

	// 返回最短路径上面的所有Edge
	public List<Edge> getMinPath(TreeNode root) {
		List<Edge> res = new ArrayList<>();
		List<Edge> temp = new ArrayList<>();
		dfs(res, temp, root, 0);
		return res;
	}

	// 就是普通的DFS
	public void dfs(List<Edge> res, List<Edge> temp, TreeNode root, int curCost) {
		if (root == null) {
			return;
		}
		// reach the leaf
		if (root.edges.size() == 0) {
			if (curCost < minCost) {
				minCost = curCost;
				res.clear();
				res.addAll(temp);
				return;
			}
		}
		for (Edge e : root.edges) {
			TreeNode next = e.node;
			temp.add(e);
			dfs(res, temp, next, curCost + e.cost);
			temp.remove(temp.size() - 1);
		}
	}

	// 这个只返回个最小cost
	public int getMinCost(TreeNode root) {
		if (root == null) {
			return 0;
		}
		helper(root, 0);
		return minCost;
	}

	public void helper(TreeNode root, int curCost) {
		if (root.edges.size() == 0) {
			minCost = Math.min(minCost, curCost);
			return;
		}
		for (Edge e : root.edges) {
			TreeNode next = e.node;
			helper(next, curCost + e.cost);
		}
	}

	public static void main(String[] args) {
		RootToLeaf test = new RootToLeaf();
		/*
		 * n1 e1 / \ e3 n2 n3 e2 / n4
		 *
		 */
		TreeNode n1 = new TreeNode();
		TreeNode n2 = new TreeNode();
		TreeNode n3 = new TreeNode();
		TreeNode n4 = new TreeNode();
		Edge e1 = new Edge(n2, 1);
		Edge e2 = new Edge(n4, 2);
		Edge e3 = new Edge(n3, 5);
		n1.edges.add(e1);
		n1.edges.add(e3);
		n2.edges.add(e2);

		List<Edge> res = test.getMinPath(n1);
		int result = test.getMinCost(n1);
		System.out.println(result);
		for (Edge e : res) {
			System.out.println(e.cost);
		}

	}
}

package com.fanchen.clearmind.indeed.vo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class RootToLeafFollowUp {

	// 复杂度是O(Elog(V))

	// 改良的DFS，就是用map记录的DFS
	int minCost = Integer.MAX_VALUE;
	Map<TreeNode, Integer> map = new HashMap<>();

	public List<Edge> getMinPathInGraph(TreeNode root) {
		List<Edge> res = new ArrayList<>();
		List<Edge> temp = new ArrayList<>();
		dfsInGraph(res, temp, root, 0);
		return res;
	}

	public void dfsInGraph(List<Edge> res, List<Edge> temp, TreeNode node, int curCost) {
		if (node == null)
			return;
		if (map.containsKey(node) && curCost >= map.get(node))
			return;
		map.put(node, curCost);
		if (node.edges.size() == 0) {
			if (curCost < minCost) {
				minCost = curCost;
				res.clear();
				res.addAll(temp);
			}
			return;
		}

		for (Edge e : node.edges) {
			TreeNode next = e.node;
			temp.add(e);
			dfsInGraph(res, temp, next, curCost + e.cost);
			temp.remove(temp.size() - 1);
		}
	}

//dijkstra，写的真难看
	public List<Edge> getMinPathInGraph1(TreeNode root) {
		int minCost = Integer.MAX_VALUE;
		TreeNode resNode = null;
		List<Edge> res = new ArrayList<>();
		Map<TreeNode, Integer> map = new HashMap<>();
		Map<TreeNode, TreeNode> findPar = new HashMap<>();
		PriorityQueue<TreeNode> pq = new PriorityQueue<>(new Comparator<TreeNode>() {
			@Override
			public int compare(TreeNode o1, TreeNode o2) {
				return map.get(o1) - map.get(o2);
			}
		});

		map.put(root, 0);
		findPar.put(root, null);
		pq.offer(root);
		while (!pq.isEmpty()) {
			TreeNode cur = pq.poll();
			int d = map.get(cur);
			if (cur.edges.size() == 0) {
				int curCost = map.get(cur);
				if (curCost < minCost) {
					minCost = curCost;
					resNode = cur;
				}
			}
			for (Edge e : cur.edges) {
				TreeNode next = e.node;
				int tempD = e.cost + d;
				if (!map.containsKey(next)) {
					map.put(next, tempD);
					findPar.put(next, cur);
					pq.offer(next);
				} else {
					if (tempD < map.get(next)) {
						pq.remove(next);
						map.put(next, tempD);
						findPar.put(next, cur);
						pq.offer(next);
					}
				}
			}
		}

//      下面都是为了输出所有的边才写的，就是把所有的node都抓出来，然后去找连接的边
		List<TreeNode> tempList = new ArrayList<>();
		while (resNode != null) {
			tempList.add(0, resNode);
			resNode = findPar.get(resNode);
		}
		for (int i = 0; i < tempList.size() - 1; i++) {
			TreeNode cur = tempList.get(i);
			for (Edge e : cur.edges) {
				if (e.node.equals(tempList.get(i + 1))) {
					res.add(e);
				}
			}
		}
		return res;
	}
}















































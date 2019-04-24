package com.fanchen.clearmind.classto.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MST_Example {

	class Connection {
		int city1;
		int city2;
		int cost;

		public Connection(int city1, int city2, int cost) {
			this.city1 = city1;
			this.city2 = city2;
			this.cost = cost;
		}
	}

	class UnionFind {
		private int[] parent;

		public UnionFind(int n) {
			parent = new int[n + 1];
			for (int i = 0; i <= n; i++) {
				parent[i] = i;
			}
		}

		public int findParent(int i) {
			while (parent[i] != i) {
				i = parent[i];
			}
			return i;
		}

		public void union(int i, int j) {
			int iParent = findParent(i);
			int jParent = findParent(j);
			parent[iParent] = jParent;

		}

		public boolean hasSameParent(int i, int j) {
			return findParent(i) == findParent(j);
		}
	}

	public int getMinimumCostToContruct(int numTotalAvailableCities, int numTotalAvailableRoads,
			List<List<Integer>> roadsAvailable, int numNewRoadsConstruct, List<List<Integer>> costNewRoadsConstruct) {

		if (numTotalAvailableCities < 2 || numTotalAvailableRoads + 1 >= numTotalAvailableCities) {
			return 0;
		}

		UnionFind uf = new UnionFind(numTotalAvailableCities);
		int currentRoadCount = 0;

		for (List<Integer> road : roadsAvailable) {
			int city1 = road.get(0);
			int city2 = road.get(1);
			if (!uf.hasSameParent(city1, city2)) {
				uf.union(city1, city2);
				currentRoadCount++;
			}
		}

		PriorityQueue<Connection> q = new PriorityQueue<>(numNewRoadsConstruct,
				(a, b) -> (Integer.compare(a.cost, b.cost)));

		for (List<Integer> road : costNewRoadsConstruct) {
			Connection cn = new Connection(road.get(0), road.get(1), road.get(2));
			q.offer(cn);
		}

		List<Connection> mst = new ArrayList<>();
		while (q.size() > 0 && mst.size() < numTotalAvailableCities - currentRoadCount - 1) {
			Connection temp = q.poll();
			int city1 = temp.city1;
			int city2 = temp.city2;
			if (!uf.hasSameParent(city1, city2)) {
				uf.union(city1, city2);
				mst.add(temp);
			}
		}

		if (mst.size() < numTotalAvailableCities - currentRoadCount - 1) {
			return -1;
		}

		int res = 0;

		for (Connection cn : mst) {
			res += cn.cost;
		}
		System.out.println(res);
		return res;
	}

	public static void main(String[] args) {
		int numTotalAvailableCities = 6;
		int numTotalAvailableRoads = 3;
		List<List<Integer>> roadsAvailable = Arrays.asList(Arrays.asList(1, 4), Arrays.asList(4, 5),
				Arrays.asList(2, 3));
		int numNewRoadsConstruct = 4;
		List<List<Integer>> costNewRoadsConstruct = Arrays.asList(Arrays.asList(1, 2, 5), Arrays.asList(1, 3, 10),
				Arrays.asList(1, 6, 2), Arrays.asList(5, 6, 5));

		MST_Example ex = new MST_Example();
		ex.getMinimumCostToContruct(numTotalAvailableCities, numTotalAvailableRoads, roadsAvailable,
				numNewRoadsConstruct, costNewRoadsConstruct);
	}
}

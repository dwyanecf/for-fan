package com.fanchen.clearmind.concept;

public class UnionFind {
    public static int[] findRedundantDirectedConnection(int[][] edges) {
        int[] parents = new int[edges.length];
        for (int i = 0; i < edges.length; i++) parents[i] = i;

        int[] candidate1 = null, candidate2 = null;
        for (int[] e : edges) {
            int x = find(parents, e[0] - 1), y = find(parents, e[1] - 1);
            if (x != y) {
                if (y != e[1] - 1) candidate1 = e; // record the last edge which results in "multiple parents" issue
                else parents[y] = x;
            } else candidate2 = e; // record last edge which results in "cycle" issue, if any.
        }

        // if there is only one issue, return this one.
        if (candidate1 == null) return candidate2;
        if (candidate2 == null) return candidate1;

        // If both issues present, then the answer should be the first edge which results in "multiple parents" issue
        // Could use map to skip this pass, but will use more memory.
        for (int[] e : edges) if (e[1] == candidate1[1]) return e;

        return new int[2];
    }

    public static int find(int[] parent, int f) {
        while (f != parent[f]) {
            f = parent[f];
        }
        return f;
    }

    public static void main(String[] args) {
//      int[][] edges = new int[][] {{1,2}, {2,3}, {3,4},{4,1},{1,5}};
//        findRedundantDirectedConnection(edges);

        int a = 0;
        double y = 1.0;
    }






}

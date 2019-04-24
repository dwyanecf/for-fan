package com.fanchen.clearmind.leetcode.unionSearch;

import java.util.HashMap;
import java.util.Map;

public class EvaluateDivision {
    public static double[] calcEquation(String[][] e, double[] values, String[][] q) {
        Map<String, String> root = new HashMap<>();
        Map<String, Double> dis = new HashMap<>();
        double[] res = new double[q.length];
        for (int i = 0; i < e.length; i++) {
            String r1 = find(root, dis, e[i][0]);
            String r2 = find(root, dis, e[i][1]);
            root.put(r1, r2);
            dis.put(r1, dis.get(e[i][1]) * values[i] / dis.get(e[i][0]));
        }
        for (int i = 0; i < q.length; i++) {
            if (!root.containsKey(q[i][0]) || !root.containsKey(q[i][1])) {
                res[i] = -1;
                continue;
            }
            String r1 = find(root, dis, q[i][0]);
            String r2 = find(root, dis, q[i][1]);
            if (!r1.equals(r2)) {
                res[i] = -1;
                continue;
            }
            res[i] = (double) dis.get(q[i][0]) / dis.get(q[i][1]);
        }
        return res;
    }

    public static String find(Map<String, String> root, Map<String, Double> dis, String s) {
        if (!root.containsKey(s)) {
            root.put(s, s);
            dis.put(s, 1.0);
            return s;
        }
        if (root.get(s).equals(s)) return s;
        String lastP = root.get(s);
        String p = find(root, dis, lastP);
        root.put(s, p);
        dis.put(s, dis.get(s) * dis.get(lastP));
        return p;
    }

    public static void main(String[] args) {
        String[][] equations = new String[][]{{"a", "b"}, {"b", "c"},{"c","d"}};
        double[] values = {2.0, 3.0, 4.0};
        String[][] queries = {{"a", "d"}};
        calcEquation(equations, values, queries);
    }
}

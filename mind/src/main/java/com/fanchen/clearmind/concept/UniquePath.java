package com.fanchen.clearmind.concept;

import java.util.*;

public class UniquePath {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                dp[i][j] += dp[i][j - 1];
                if (i > 0) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
                if (i + 1 < m) {
                    dp[i][j] += dp[i + 1][j - 1];
                }
            }
        }
        return dp[0][n - 1];
    }

    public int f1(int m, int n) {
        int[] dp = new int[m];
        int[] temp = new int[m];
        // for column 0
        dp[0] = 1;
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                temp[i] += dp[i];
                if (i > 0) temp[i] += dp[i - 1];
                if (i + 1 < m) temp[i] += dp[i + 1];
            }
            System.arraycopy(temp, 0, dp, 0, temp.length);
        }
        return dp[0];
    }


    // follow up 2
    public boolean canReach(int[][] points) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{0, 0});
        for (int[] point : points) {
            list.add(point);
        }
        Collections.sort(list, (a, b) -> a[1] - b[1]);
        for (int i = 1; i < list.size(); i++) {
            int[] cur = list.get(i);
            int[] pre = list.get(i - 1);
            if (cur[1] == pre[1]) return false;
            int len = cur[1] - pre[1];
            int lo = pre[0] - len;
            int hi = pre[0] + len;
            if (cur[0] >= lo && cur[0] >= hi) continue;
            return false;
        }
        return true;
    }

    //follow up 3
    public int f3(int m, int n, int[][] points) {
        int[] dp = new int[m];
        int[] temp = new int[m];
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] point : points) {
            if (map.containsKey(point[1])) {
                return 0;
            } else {
                map.put(point[1], point[0]);
            }
        }
        int res = 0;
        // for column 0
        dp[0] = 1;
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                temp[i] += dp[i];
                if (i > 0) temp[i] += dp[i - 1];
                if (i + 1 < m) temp[i] += dp[i + 1];
            }
            System.arraycopy(temp, 0, dp, 0, temp.length);
            if (map.containsKey(j)) {
                int row = map.get(j);
                for (int k = 0; k < m; k++) {
                    if (k != row) {
                        dp[k] = 0;
                    } else {
                        res = dp[k];
                    }
                }
            }
        }
        return res;
    }

    public int uniquePaths(int rows, int cols, int H) {
        return uniquePaths(rows, cols) - uniquePaths(H, cols);
    }
}

package com.fanchen.clearmind.leetcode.map.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForSum {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (num == null || num.length < 4) return res;
        Arrays.sort(num);
        int n = num.length;
        for (int i = 0; i < num.length - 3; i++) {
            if (num[i] + num[i + 1] + num[i + 2] + num[i + 3] > target) break;
            if (num[i] + num[n - 3] + num[n - 1] + num[n - 2] < target) continue;
            if (i > 0 && num[i] == num[i - 1]) continue;
            for (int j = i + 1; j < num.length - 2; j++) {
                if (num[i] + num[j] + num[j + 1] + num[j + 2] > target) break;
                if (num[i] + num[j] + num[n - 1] + num[n - 2] < target) continue;
                if (j > i + 1 && num[j] == num[j - 1]) continue;
                int lo = j + 1;
                int hi = n - 1;
                while (lo < hi) {
                    int sum = num[i] + num[j] + num[lo] + num[hi];
                    if (sum == target) {
                        res.add(Arrays.asList(num[i], num[j], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo + 1]) lo++;
                        while (lo < hi && num[hi] == num[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (sum < target) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }
}

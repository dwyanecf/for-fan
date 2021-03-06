package com.fanchen.clearmind.leetcode.map.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Integer>[] freq = new ArrayList[nums.length + 1];
        for (int n : map.keySet()) {
            int times = map.get(n);
            if (freq[times] == null) freq[times] = new ArrayList<>();
            freq[times].add(n);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = freq.length - 1; i >= 0 && res.size() < k; i--) {
            if (freq[i] != null) res.addAll(freq[i]);
        }
        return res;
    }
}

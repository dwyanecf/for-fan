package com.fanchen.clearmind.leetcode.ama.OA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC347 {

	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		List<Integer>[] freq = new List[nums.length + 1];
		for (int key : map.keySet()) {
			int count = map.get(key);
			if (freq[count] == null) {
				freq[count] = new ArrayList<>();
			}
			freq[count].add(key);
		}
		int[] res = new int[k];
		int index = 0;
		for (int i = freq.length - 1; i >= 0 && index < k; i--) {
			if (freq[i] != null) {
				for (int j : freq[i]) {
					res[index++] = j;
				}
			}
		}
		return res;
	}
}

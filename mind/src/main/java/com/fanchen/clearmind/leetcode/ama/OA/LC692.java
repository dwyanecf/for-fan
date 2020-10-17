package com.fanchen.clearmind.leetcode.ama.OA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LC692 {
	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> map = new HashMap<>();
		for (String w : words) {
			map.put(w, map.getOrDefault(w, 0) + 1);
		}
		// <word, frequency>
		PriorityQueue<Map.Entry<String, Integer>> q = new PriorityQueue<>((a,
				b) -> a.getValue() != b.getValue() ? a.getValue() - b.getValue() : b.getKey().compareTo(a.getKey()));
		for (Map.Entry<String, Integer> e : map.entrySet()) {
			q.offer(e);
			if (q.size() > k) {
				q.poll();
			}
		}
		List<String> list = new ArrayList<>();
		for (int i = 0; i < k && !q.isEmpty(); i++) {
			list.add(0, q.poll().getKey());
		}
		return list;
	}
}

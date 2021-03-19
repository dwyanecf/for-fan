package com.fanchen.clearmind.zillow.dianmian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LC373FindKPairsWithSmallestSums {
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		PriorityQueue<List<Integer>> que = new PriorityQueue<>((a, b) -> a.get(0) + a.get(1) - b.get(0) - b.get(1));
		List<List<Integer>> res = new ArrayList<>();
		if (nums1.length == 0 || nums2.length == 0 || k == 0)
			return res;
		for (int i = 0; i < nums1.length && i < k; i++)
			que.offer(Arrays.asList(nums1[i], nums2[0], 0));
		while (k-- > 0 && !que.isEmpty()) {
			List<Integer> cur = que.poll();
			res.add(Arrays.asList(cur.get(0), cur.get(1)));
			if (cur.get(2) == nums2.length - 1)
				continue;
			que.offer(Arrays.asList(cur.get(0), nums2[cur.get(2) + 1], cur.get(2) + 1));
		}
		return res;
	}

}

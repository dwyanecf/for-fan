package com.fanchen.clearmind.zillow.VO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingScheduler {
	public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		push(pq, slots1, duration);
		push(pq, slots1, duration);

		int[] pre = pq.poll();
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			if (cur[0] + duration <= pre[1]) {
				return new ArrayList<>(Arrays.asList(cur[0], cur[0] + duration));
			}
			pre = cur;
		}
		return new ArrayList<>();
	}

	private void push(PriorityQueue<int[]> pq, int[][] slot, int duration) {
		for (int[] s : slot) {
			if (s[1] - s[0] >= duration) {
				pq.offer(s);
			}
		}

	}

}

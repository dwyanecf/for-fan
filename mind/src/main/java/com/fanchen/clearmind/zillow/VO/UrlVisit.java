package com.fanchen.clearmind.zillow.VO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class UrlVisit {

	Map<String, Visit> map;

	PriorityQueue<Visit> pq;

	class Visit {
		String url;
		List<String> timeStamps;

		public Visit(String url, String time) {
			this.url = url;
			this.timeStamps = new ArrayList<>();
			timeStamps.add(time);
		}

		public void addTime(String time) {
			this.timeStamps.add(time);
		}

	}

	public List<String> findRecentKUrls(int k) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			if (!pq.isEmpty()) {
				list.add(pq.poll().url);
			}
		}
		return list;

	}

	public UrlVisit() {
		map = new HashMap<>();
		pq = new PriorityQueue<Visit>((a, b) -> b.timeStamps.size() - a.timeStamps.size());
	}

	public void visit(String url, String time) {
		if (!map.containsKey(url)) {
			Visit v = new Visit(url, time);
			map.put(url, v);
			pq.offer(v);

		} else {
			Visit v = map.get(url);
			v.addTime(time);
		}
	}

}

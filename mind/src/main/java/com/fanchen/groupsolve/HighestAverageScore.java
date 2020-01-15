package com.fanchen.groupsolve;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HighestAverageScore {

	public double averageScore(String[][] list) {
		Map<String, List<Integer>> map = new HashMap<>();
		for (String[] detail : list) {
			if (!map.containsKey(detail[0])) {
				map.put(detail[0], new ArrayList<>());
			}
			map.get(detail[0]).add(Integer.parseInt(detail[1]));
		}

		double max = Integer.MIN_VALUE;
		for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
			int size = entry.getValue().size();
			int sum = entry.getValue().stream().mapToInt(e -> e).sum();
			max = Math.max(max, (double) (sum / size));
		}
		System.out.println(max);
		return max;
	}

	public static void main(String[] args) {
		HighestAverageScore obj = new HighestAverageScore();
		obj.averageScore(new String[][] { { "Bob", "87" }, { "Mike", "35" }, { "Bob", "52" }, { "Jason", "35" },
				{ "Mike", "55" }, { "Jessica", "99" } });
	}
}

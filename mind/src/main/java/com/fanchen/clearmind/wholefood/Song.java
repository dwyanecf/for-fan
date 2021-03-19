package com.fanchen.clearmind.wholefood;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Song {
	class Pair {
		int value;
		int index;

		public Pair(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	ArrayList<Integer> IDsOfSongs(int rideDuration, ArrayList<Integer> songDurations) {
		if (songDurations == null || songDurations.size() == 0) {
			return new ArrayList<>();
		}
		List<Pair> pairs = new ArrayList<>();
		for (int i = 0; i < songDurations.size(); i++) {
			pairs.add(new Pair(songDurations.get(i), i));
		}
		Collections.sort(pairs, (a, b) -> a.value - b.value);
		int left = 0;
		int right = songDurations.size() - 1;
		songDurations.add(60);
		int min = Integer.MAX_VALUE;
		int[] ans = new int[2];
		while (left < right) {
			int sum = pairs.get(left).value + pairs.get(right).value;
			if (sum <= rideDuration - 30) {
				if (Math.abs(sum - rideDuration) < min) {
					ans[0] = pairs.get(left).index;
					ans[1] = pairs.get(right).index;
					min = Math.abs(sum - rideDuration);
				}
				left++;
			} else {
				right--;
			}
		}
		ArrayList<Integer> res = new ArrayList<>();
		if (min == Integer.MAX_VALUE) {
			return res;
		}

		res.add(Math.min(ans[0], ans[1]));
		res.add(Math.max(ans[0], ans[1]));
		return res;
	}
}

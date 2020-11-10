package com.fanchen.clearmind.leetcode.yama.vo;

import java.util.Map;

public class WalkTheWayWeWalked {

	class Coordination {
		int x;
		int y;

		public Coordination(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	Map<int[], Boolean> map;
	int[] loc = { 0, 0 };

	public boolean walk(Character c, int l) {

		switch (c) {
		case 'U':
			loc[1] += l;
			break;
		case 'D':
			loc[1] -= l;
			break;
		case 'L':
			loc[0] -= l;
			break;
		case 'R':
			loc[0] += l;
			break;
		}
		if (map.containsKey(loc)) {
			return false;
		}
		map.put(loc, true);
		return true;

	}

}

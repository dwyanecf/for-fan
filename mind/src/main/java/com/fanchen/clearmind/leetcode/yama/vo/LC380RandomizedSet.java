package com.fanchen.clearmind.leetcode.yama.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class LC380RandomizedSet {
	List<Integer> list;
	// val, index of list
	Map<Integer, Integer> map;
	Random ran;

	/** Initialize your data structure here. */
	public LC380RandomizedSet() {
		list = new ArrayList<>();
		map = new HashMap<>();
		ran = new Random();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {
		if (map.containsKey(val)) {
			return false;
		} else {
			list.add(val);
			map.put(val, list.size() - 1);
			return true;
		}

	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 */
	public boolean remove(int val) {
		if (!map.containsKey(val)) {
			return false;
		} else {
			int index = map.get(val);
			int lastNum = list.get(list.size() - 1);
			list.set(index, lastNum);
			map.put(lastNum, index);
			map.remove(val);
			list.remove(list.size() - 1);
			return true;
		}
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return list.get(ran.nextInt(list.size()));
	}
}

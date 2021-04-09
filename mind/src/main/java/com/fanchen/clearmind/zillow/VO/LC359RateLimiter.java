package com.fanchen.clearmind.zillow.VO;

import java.util.HashMap;
import java.util.Map;

public class LC359RateLimiter {

	Map<String, Integer> map;

	/** Initialize your data structure here. */
	public LC359RateLimiter() {
		map = new HashMap<>();
	}

	/**
	 * Returns true if the message should be printed in the given timestamp,
	 * otherwise returns false. If this method returns false, the message will not
	 * be printed. The timestamp is in seconds granularity.
	 */
	public boolean shouldPrintMessage(int timestamp, String message) {
		if (map.getOrDefault(message, 0) <= timestamp) {
			map.put(message, timestamp + 10);
			return true;
		} else {
			return false;
		}
	}
}

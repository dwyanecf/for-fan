package com.fanchen.clearmind.leetcode.yama.vo;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class LC359Logger {
	/**
	 * Design a logger system that receive stream of messages along with its
	 * timestamps, each message should be printed if and only if it is not printed
	 * in the last 10 seconds.
	 * 
	 * Given a message and a timestamp (in seconds granularity), return true if the
	 * message should be printed in the given timestamp, otherwise returns false.
	 * 
	 * It is possible that several messages arrive roughly at the same time.
	 * 
	 * Example:
	 * 
	 * Logger logger = new Logger();
	 * 
	 * // logging string "foo" at timestamp 1 logger.shouldPrintMessage(1, "foo");
	 * returns true;
	 * 
	 * // logging string "bar" at timestamp 2 logger.shouldPrintMessage(2,"bar");
	 * returns true;
	 * 
	 * // logging string "foo" at timestamp 3 logger.shouldPrintMessage(3,"foo");
	 * returns false;
	 * 
	 * // logging string "bar" at timestamp 8 logger.shouldPrintMessage(8,"bar");
	 * returns false;
	 * 
	 * // logging string "foo" at timestamp 10 logger.shouldPrintMessage(10,"foo");
	 * returns false;
	 * 
	 * // logging string "foo" at timestamp 11 logger.shouldPrintMessage(11,"foo");
	 * returns true;
	 */

	HashMap<String, Integer> record;

	/** Initialize your data structure here. */
	public LC359Logger() {
		record = new HashMap<String, Integer>();
	}

	/**
	 * Returns true if the message should be printed in the given timestamp,
	 * otherwise returns false. If this method returns false, the message will not
	 * be printed. The timestamp is in seconds granularity.
	 */
	public boolean shouldPrintMessage(int timestamp, String message) {
		/*
		 * if(record.containsKey(message)){ if( timestamp-record.get(message) >=10){
		 * record.put(message, timestamp); return true; } else{ return false; }
		 * 
		 * } else{ record.put(message, timestamp); return true; }
		 */
		// 以上是非常连贯的逻辑，一步步做判断，下面是 精简后的判断条件，所以速度上快很多，但是如果没写出上面的代码，没看到重复出现的那两行，可能也不会想到下面的写法

		if (record.containsKey(message) && timestamp - record.get(message) < 10) {
			return false;
		} else {
			record.put(message, timestamp);
			return true;
		}

	}

	public static void main(String[] args) {
		// create an instance of
		// ConcurrentHashMap
		ConcurrentHashMap<Integer, String> m = new ConcurrentHashMap<>();

		// Insert mappings using
		// put method
		m.put(100, "Hello");
		m.put(101, "Geeks");
		m.put(102, "Geeks");

		// Here we cant add Hello because 101 key
		// is already present in ConcurrentHashMap object
		m.putIfAbsent(101, "Hello");

		// We can remove entry because 101 key
		// is associated with For value
		m.remove(101, "Geeks");

		// Now we can add Hello
		m.putIfAbsent(103, "Hello");

		// We cant replace Hello with For
		m.replace(101, "Hello", "For");
		System.out.println(m);
	}
}

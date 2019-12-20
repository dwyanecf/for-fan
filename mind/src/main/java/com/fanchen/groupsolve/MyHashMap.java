/*
 * Copyright (C) 2019 Copart, Inc. All rights reserved.
 */
package com.fanchen.groupsolve;

/**
 * @author fachen
 *
 */
public class MyHashMap {
	static class ListNode {
		int key;
		int val;
		ListNode next;

		ListNode(int key, int val, ListNode next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}

	ListNode[] map;

	/** Initialize your data structure here. */
	public MyHashMap() {
		map = new ListNode[10000];
	}

	ListNode find(ListNode x, int key) {
		if (x == null)
			return null;
		if (x.key == key)
			return x;
		return find(x.next, key);
	}

	ListNode remove(ListNode x, int key) {
		if (x == null)
			return null;
		if (x.key == key)
			return x.next;
		x.next = remove(x.next, key);
		return x;
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		int hash = key % 10000;
		ListNode x = find(map[hash], key);
		if (x != null) {
			x.val = value;
		} else {
			map[hash] = new ListNode(key, value, map[hash]);
		}
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map
	 * contains no mapping for the key
	 */
	public int get(int key) {
		int hash = key % 10000;
		ListNode x = find(map[hash], key);
		if (x != null)
			return x.val;
		return -1;
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping
	 * for the key
	 */
	public void remove(int key) {
		int hash = key % 10000;
		map[hash] = remove(map[hash], key);
	}

}

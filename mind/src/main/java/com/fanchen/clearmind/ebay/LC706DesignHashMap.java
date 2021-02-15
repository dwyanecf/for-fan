package com.fanchen.clearmind.ebay;

public class LC706DesignHashMap {

	class Node {
		Node next;
		int key;
		int val;

		public Node(Node next, int key, int val) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}

	Node[] array;

	/** Initialize your data structure here. */
	public LC706DesignHashMap() {
		array = new Node[10000];
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		int hash = key % 10000;
		Node n = find(array[hash], key);
		if (n != null) {
			n.val = value;
		} else {
			array[hash] = new Node(array[hash], key, value);
		}
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map
	 * contains no mapping for the key
	 */
	public int get(int key) {
		int hash = key % 10000;
		Node n = find(array[hash], key);
		if (n != null) {
			return n.val;
		} else {
			return -1;
		}
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping
	 * for the key
	 */
	public void remove(int key) {
		int hash = key % 10000;
		array[hash] = remove(array[hash], key);
	}

	public Node find(Node n, int key) {
		if (n == null || n.key == key) {
			return n;
		}
		return find(n.next, key);
	}

	public Node remove(Node n, int key) {
		if (n == null)
			return n;
		if (n.key == key) {
			return n.next;
		}
		n.next = remove(n.next, key);
		return n;
	}
}

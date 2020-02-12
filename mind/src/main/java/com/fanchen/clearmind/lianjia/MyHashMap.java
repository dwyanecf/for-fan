package com.fanchen.clearmind.lianjia;

class MyHashMap {
	class Node {
		int key;
		int val;
		Node next;

		public Node(int key, int val, Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}

	Node[] map;

	/** Initialize your data structure here. */
	public MyHashMap() {
		map = new Node[10000];
	}

	public Node find(Node root, int key) {
		if (root == null) {
			return root;
		}
		if (root.key == key) {
			return root;
		}
		return find(root.next, key);
	}

	public Node remove(Node root, int key) {
		if (root == null) {
			return root;
		}
		if (root.key == key) {
			return root.next;
		}
		root.next = remove(root.next, key);
		return root;
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		int hash = key % 10000;
		Node x = find(map[hash], key);
		if (x != null) {
			x.val = value;
		} else {
			map[hash] = new Node(key, value, map[hash]);
		}
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map
	 * contains no mapping for the key
	 */
	public int get(int key) {
		int hash = key % 10000;
		Node x = find(map[hash], key);
		if (x != null) {
			return x.val;
		}
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
	
		public static void main(String[] args) {
			MyHashMap obj = new MyHashMap();
			obj.put(1, 1);
			obj.put(10001, 2);
			obj.get(10001);
		}

}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj
 * = new MyHashMap(); obj.put(key,value); int param_2 = obj.get(key);
 * obj.remove(key);
 */

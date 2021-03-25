package com.fanchen.clearmind.zillow.VO;

import java.util.HashMap;
import java.util.Map;

public class LRU {
	class Node {
		Node pre;
		Node next;
		int val;
		int key;

		public Node() {
			pre = null;
			next = null;
		}

		public Node(int key, int val) {
			this.val = val;
			this.key = key;
		}
	}

	Node head;
	Node tail;
	Map<Integer, Node> map;
	int cap;
	int count;

	public LRU(int capacity) {
		this.cap = capacity;
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.pre = head;
		map = new HashMap<>();
		count = 0;
	}

	public void add(Node n) {
		Node second = head.next;
		head.next = n;
		n.pre = head;
		n.next = second;
		second.pre = n;
	}

	public void remove(Node n) {
		Node before = n.pre;
		Node after = n.next;
		before.next = after;
		after.pre = before;
	}

	public void update(Node n) {
		remove(n);
		add(n);

	}

	public int get(int key) {
		Node n = map.get(key);
		if (n != null) {
			update(n);
			return n.val;
		} else {
			return -1;
		}
	}

	public void put(int key, int value) {
		Node n = map.get(key);
		if (n != null) {
			update(n);
			n.val = value;
			return;
		} else {
			Node newNode = new Node(key, value);
			map.put(key, newNode);
			count++;
			add(newNode);
			if (cap < count) {
				Node toDelete = tail.pre;
				remove(toDelete);
				map.remove(toDelete.key);
				count--;
			}
		}
	}

}

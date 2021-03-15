package com.fanchen.clearmind.zillow.dianmian;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	class Node {
		Node pre;
		Node next;
		int key;
		int val;

		public Node() {
			pre = null;
			next = null;
		}

		public Node(int key, int val) {
			this.key = key;
			this.val = val;
			pre = null;
			next = null;
		}
	}

	Node head;
	Node tail;
	Map<Integer, Node> map;
	int cap;
	int count;

	public LRUCache(int capacity) {
		this.cap = capacity;
		count = 0;
		map = new HashMap<>();
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.pre = head;

	}

	public void remove(Node n) {
		Node before = n.pre;
		Node after = n.next;
		before.next = after;
		after.pre = before;
	}

	public void add(Node n) {
		Node second = head.next;
		head.next = n;
		n.pre = head;
		n.next = second;
		second.pre = n;
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
		}
		return -1;
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

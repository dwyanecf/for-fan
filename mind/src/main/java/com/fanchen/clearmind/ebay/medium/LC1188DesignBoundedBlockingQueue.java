package com.fanchen.clearmind.ebay.medium;

import java.util.Deque;
import java.util.LinkedList;

public class LC1188DesignBoundedBlockingQueue {
	Deque<Integer> deq;
	int size;
	Object lock;

	public LC1188DesignBoundedBlockingQueue(int capacity) {
		deq = new LinkedList<>();
		size = capacity;
		lock = new Object();
	}

	public void enqueue(int element) throws InterruptedException {
		synchronized (lock) {
			while (deq.size() == size) {
				lock.wait();
			}
			deq.addLast(element);
			lock.notify();
		}
	}

	public int dequeue() throws InterruptedException {
		int val = 0;
		synchronized (lock) {
			while (deq.isEmpty()) {
				lock.wait();
			}
			val = deq.removeFirst();
			lock.notify();
		}
		return val;
	}

	public int size() {
		return deq.size();
	}
}

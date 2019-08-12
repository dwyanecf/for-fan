/*
 * Copyright (C) 2019 Copart, Inc. All rights reserved.
 */
package com.fanchen.clearmind.concept.start.point;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author fachen
 *
 */
public class Movingaverage {
	private Queue<Event> queue = new LinkedList<>();
	private int sum = 0;

	// record an event
	public void record(int val) {
		Event event = new Event(getNow(), val);
		queue.offer(event);
		sum += event.val;

		removeExpiredRecords();
	}

	private int getNow() {
		return 0;
	}

	private void removeExpiredRecords() {
		while (!queue.isEmpty() && expired(getNow(), queue.peek().time)) {
			Event curr = queue.poll();
			sum -= curr.val;
		}
	}

	private double getAvg() {
		removeExpiredRecords();
		if (queue.isEmpty()) {
			return 0;
		} else {
			return sum * 1.0 / queue.size();
		}
	}

	private boolean expired(int currTime, int prevTime) {
		return currTime - prevTime > 5;
	}

	class Event {
		int time;
		int val;

		public Event(int time, int val) {
			this.time = time;
			this.val = val;
		}
	}
}

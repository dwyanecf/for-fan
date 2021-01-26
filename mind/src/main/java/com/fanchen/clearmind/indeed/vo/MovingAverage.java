package com.fanchen.clearmind.indeed.vo;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {

	class Event {
		int time;
		int val;

		public Event(int time, int val) {
			this.time = time;
			this.val = val;
		}
	}

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
		while (!queue.isEmpty() && isExpired(getNow(), queue.peek().time)) {
			Event curr = queue.poll();
			sum -= curr.val;
		}
	}

	private double getAvg() {
		removeExpiredRecords();
		if (queue.isEmpty()) {
			return 0;
		} else {
			return (double) sum / queue.size();
		}
	}

	private boolean isExpired(int currTime, int prevTime) {
		return currTime - prevTime > 5;
	}

}

package com.fanchen.clearmind.indeed.vo;

import java.util.Deque;
import java.util.LinkedList;

public class MovingAverageFollowUp {

	class Event {
		int val;
		int time;
		int size;

		public Event(int val, int time) {
			this.val = val;
			this.time = time;
			this.size = 1;
		}

		// queue的容量被限制
		private Deque<Event> queue = new LinkedList<>(); // 改成deque的话，可以从后面查
		private long sum = 0; // 改用long显得严谨点儿
		int count = 0;

		// 这个是每次记录读进来的时间的,这个不用自己写,就是直接返回当前系统时间
		// 假设它返回的是秒
		private int getNow() {
			return 0;
		}

		private boolean isExpired(int curTime, int preTime) {
			return curTime - preTime > 300;
		}

		private void removeExpireEvent() {
			while (!queue.isEmpty() && isExpired(getNow(), queue.peekFirst().time)) {
				Event curE = queue.poll();
				sum -= curE.val;
				count -= curE.size;
			}
		}

		public void record(int val) { // 其实就是record这里有了两种办法，一种是建个新的，另一种就是合起来
			Event last = queue.peekLast();
			if (getNow() - last.time < 10) {
				last.size += 1;
				last.val += val;
			} else {
				Event event = new Event(getNow(), val);
				queue.offer(event);
			}
			count += 1;
			sum += val;
			removeExpireEvent();
		}

		public double getAvg() {
			removeExpireEvent();
			if (!queue.isEmpty()) {
				return (double) sum / count;
			}
			return 0.0;
		}

		// 原有基础上实现的话，那就直接quick select的办法了。
		// 复杂度是On，因为每次average case是去掉一半，就是O(n)+O(n/2)+O(n/4)+... 最后出来是O(2n)
		// 那这个需要把整个queue给倒出来再塞回去。
		public double getMedian() {
			removeExpireEvent();
			int[] temp = new int[queue.size()];
			for (int i = 0; i < queue.size(); i++) {
				temp[i] = queue.poll().val;
			}
			// 这里还得把queue还原回去,先不写了。
			int len = temp.length;
			if (len % 2 == 0) {
				return 0.5 * (findKth(temp, len / 2, 0, len - 1) + findKth(temp, len / 2 - 1, 0, len - 1));
			}
			return (double) findKth(temp, len / 2, 0, len - 1);
		}

		// The worst case time complexity of this method is O(n2), but it works in O(n) on average. 
		public int findKth(int[] array, int k, int start, int end) {
			int pivot = array[start];
			int lo = start, hi = end;
			while (lo < hi) {
				while (array[hi] > pivot && lo < hi) {
					hi--;
				}
				while (array[lo] <= pivot && lo < hi) {
					lo++;
				}
				swap(array, lo, hi);
			}
			swap(array, start, hi);
			if (k == hi) {
				return pivot;
			} else if (k < hi) {
				return findKth(array, k, start, hi - 1);
			}

			return findKth(array, k, hi + 1, end);
		}

		public void swap(int[] temp, int lo, int hi) {
			int i = temp[lo];
			temp[lo] = temp[hi];
			temp[hi] = i;
		}

	}

}

























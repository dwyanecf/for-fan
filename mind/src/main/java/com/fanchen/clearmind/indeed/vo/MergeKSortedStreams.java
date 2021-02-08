package com.fanchen.clearmind.indeed.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

class Data {
	Stream stream;
	int val;

	public Data(Stream s) {
		this.stream = s;
		this.val = s.getValue();
	}
}

class Stream {
	Iterator<Integer> iterator;

	public Stream(List<Integer> list) {
		iterator = list.iterator();
	}

	public boolean move() {
		return iterator.hasNext();
	}

	public int getValue() {
		return iterator.next();
	}
}

public class MergeKSortedStreams {

	public static void main(String[] args) {
		MergeKSortedStreams test = new MergeKSortedStreams();
		List<Integer> l1 = Arrays.asList(1, 2, 3, 3, 4);
		List<Integer> l2 = Arrays.asList(2, 3, 5, 6);
		List<Integer> l3 = Arrays.asList(2, 5, 7);

		List<Stream> lists = new ArrayList<>();
		lists.add(new Stream(l1));
		lists.add(new Stream(l2));
		lists.add(new Stream(l3));
		List<Integer> res = test.getNumberInAtLeastKStream(lists, 2);
		System.out.println(res);
	}

	// O(sum*k*len)
	public List<Integer> getNumberInAtLeastKStream(List<Stream> lists, int k) {
		List<Integer> res = new ArrayList<>();
		if (lists == null || lists.size() < k)
			return res;

		PriorityQueue<Data> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
		for (Stream s : lists) { // logK
			if (s.move()) {
				pq.offer(new Data(s));
			}
		}

		/**
		 * List<Integer> l1 = Arrays.asList(1, 2, 3, 3, 4); 
		 * List<Integer> l2 = Arrays.asList(2, 3, 5, 6); 
		 * List<Integer> l3 = Arrays.asList(2, 5, 7);
		 * 
		 */
		while (!pq.isEmpty()) { // O(sum)
			Data cur = pq.poll();
			int curVal = cur.val;
			int count = 1;
			while (cur.stream.move()) { // O(len) m is the max length of each stream
				int nextVal = cur.stream.getValue();
				if (nextVal == curVal) {
					continue;
				} else {
					cur.val = nextVal;
					pq.offer(cur);
					break;
				}
			}
			// 更新其他stream的头部，就是把指针往后挪，相同的数字就计数了。
			while (!pq.isEmpty() && curVal == pq.peek().val) { // O(k) n is the number of streams
				count++;
				Data num = pq.poll(); // poll current same number
				while (num.stream.move()) { // O(len) m is the max length of each stream
					int nextVal = num.stream.getValue();
					if (curVal == nextVal) {
						continue;
					} else {
						num.val = nextVal;
						pq.offer(num);
						break;
					}
				}
			}

			if (count >= k) {
				res.add(curVal);
			}
		}
		return res;
	}
	
	
	
	// nk log(k)  k is the number of streams, nk is the total number of numbers

}














































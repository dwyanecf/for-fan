package com.fanchen.clearmind.zillow.VO;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LC281ZigzagIterator {
	public class ZigzagIterator {
		LinkedList<Iterator> list;

		public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
			list = new LinkedList<Iterator>();
			if (!v1.isEmpty())
				list.add(v1.iterator());
			if (!v2.isEmpty())
				list.add(v2.iterator());
		}

		public int next() {
			Iterator poll = list.remove();
			int result = (Integer) poll.next();
			if (poll.hasNext())
				list.add(poll);
			return result;
		}

		public boolean hasNext() {
			return !list.isEmpty();
		}

		public int current() {
			Iterator poll = list.getFirst();
			if (poll.hasNext()) {
				return (Integer) poll.next();
			}
			return -1;
		}
	}
}

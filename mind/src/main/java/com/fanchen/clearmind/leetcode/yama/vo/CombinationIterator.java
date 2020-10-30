package com.fanchen.clearmind.leetcode.yama.vo;

import java.util.LinkedList;
import java.util.Queue;

public class CombinationIterator {

//	
//	CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.
//
//	iterator.next(); // returns "ab"
//	iterator.hasNext(); // returns true
//	iterator.next(); // returns "ac"
//	iterator.hasNext(); // returns true
//	iterator.next(); // returns "bc"
//	iterator.hasNext(); // returns false

	Queue<String> q = new LinkedList<>();

	public CombinationIterator(String characters, int combinationLength) {
		build(characters, combinationLength, 0, new StringBuilder());
	}

	public void build(String s, int k, int start, StringBuilder sb) {
		if (k == 0) {
			q.offer(sb.toString());
			System.out.println(sb.toString());
			return;
		}
		for (int i = start; i <= s.length() - k; i++) {
			sb.append(s.charAt(i));
			build(s, k - 1, i + 1, sb);
			sb.setLength(sb.length() - 1);
		}

	}

	public String next() {
		return q.poll();
	}

	public boolean hasNext() {
		return !q.isEmpty();
	}

	public static void main(String[] args) {
		CombinationIterator obj = new CombinationIterator("abc", 2);

	}
}

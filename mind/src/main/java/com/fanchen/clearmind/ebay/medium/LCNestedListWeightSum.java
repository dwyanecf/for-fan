package com.fanchen.clearmind.ebay.medium;

import java.util.List;

public class LCNestedListWeightSum {

	public int depthSum(List<NestedInteger> nestedList) {
		return helper(nestedList, 1);
	}

	public int helper(List<NestedInteger> nestedList, int depth) {
		int sum = 0;
		for (NestedInteger n : nestedList) {
			sum += n.isInteger() ? n.getInteger() * depth : helper(n.getList(), depth + 1);
		}
		return sum;
	}

	public interface NestedInteger {

		// @return true if this NestedInteger holds a single integer, rather than a
		// nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds a
		// single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// @return the nested list that this NestedInteger holds, if it holds a nested
		// list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}
}

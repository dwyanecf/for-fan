package com.fanchen.clearmind.leetcode.yama.OA;

import java.util.ArrayList;
import java.util.List;

public class LC763 {

	public List<Integer> partitionLabels(String S) {
		if (S == null || S.length() == 0)
			return null;
		List<Integer> list = new ArrayList<>();
		int[] table = new int[26];
		for (int i = 0; i < S.length(); i++) {
			table[S.charAt(i) - 'a'] = i;
		}
		int curLast = 0;
		int curLeft = 0;
		for (int i = 0; i < S.length(); i++) {
			curLast = Math.max(curLast, table[S.charAt(i) - 'a']);
			if (curLast == i) {
				list.add(curLast - curLeft + 1);
				curLeft = curLast + 1;
			}
		}
		return list;
	}

}

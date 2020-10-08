package com.fanchen.clearmind.leetcode.ama;

import java.util.ArrayList;
import java.util.List;

public class UtilityChecks {

	/**
	 * https://leetcode.com/discuss/interview-question/376019/twitter-oa-2019-autoscale-policy
	 * 
	 * @param instance
	 * @param averageUtil
	 * @return
	 */
	public static int finalInstance(int instance, List<Integer> averageUtil) {
		if (averageUtil.size() == 0 || averageUtil == null || instance == 0)
			return 0;

		int cursor = 0;
		while (cursor < averageUtil.size()) {
			int utilization = averageUtil.get(cursor);
			if (utilization > 60 && instance <= 2e8) {
				instance = instance * 2;
				cursor = cursor + 10;
			} else if (utilization < 25 && instance > 1) {
				instance = instance / 2;
				cursor = cursor + 10;
			} else {
				cursor = cursor + 1;
				continue;
			}
			cursor = cursor + 1;
		}
		System.out.println(instance);
		return instance;
	}

	public static void main(String[] args) {
		List<Integer> averageUtil = new ArrayList<>();
		averageUtil.add(5);
		averageUtil.add(10);
		averageUtil.add(80);
		/*
		 * averageUtil.add(25); averageUtil.add(23); averageUtil.add(1);
		 * averageUtil.add(2); averageUtil.add(3); averageUtil.add(4);
		 * averageUtil.add(5); averageUtil.add(6); averageUtil.add(7);
		 * averageUtil.add(8); averageUtil.add(9); averageUtil.add(10);
		 * averageUtil.add(76); averageUtil.add(80);
		 */
		finalInstance(1, averageUtil);

	}
}

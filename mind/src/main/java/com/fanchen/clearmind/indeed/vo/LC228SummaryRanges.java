package com.fanchen.clearmind.indeed.vo;

import java.util.ArrayList;
import java.util.List;

public class LC228SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
		List<String> list = new ArrayList<>();
		if (nums.length == 1) {
			list.add(String.valueOf(nums[0]));
			return list;
		}
		for (int i = 0; i < nums.length; i++) {
			int a = nums[i];
			// list.add(String.valueOf(a));
			while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
				i++;
			}
			if (a == nums[i]) {
				list.add(String.valueOf(nums[i]));
			} else {
				list.add(a + "->" + nums[i]);
			}
		}
		return list;
	}
}

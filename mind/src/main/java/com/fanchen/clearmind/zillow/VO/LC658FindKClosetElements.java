package com.fanchen.clearmind.zillow.VO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LC658FindKClosetElements {
	public List<Integer> findClosestElements(int[] nums, int k, int x) {
		int lo = 0, hi = nums.length - k;
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (x - nums[mid] > nums[mid + k] - x)
				lo = mid + 1;
			else
				hi = mid;
		}
		return Arrays.stream(nums, lo, lo + k).boxed().collect(Collectors.toList());
	}

}

package com.fanchen.clearmind.indeed.vo;

public class LC453 {

	/**
	 * Adding 1 to n - 1 elements is the same as subtracting 1 from one element,
	 * w.r.t goal of making the elements in the array equal. So, best way to do this
	 * is make all the elements in the array equal to the min element. sum(array) -
	 * n * minimum
	 * 
	 * @param nums
	 * @return
	 */
	public int minMoves(int[] nums) {
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for (int num : nums) {
			sum += num;
			min = Math.min(min, num);
		}
		return sum - nums.length * min;
	}
}

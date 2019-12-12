package com.fanchen.clearmind.leetcode.ama;

/**
 * Example:
 * 
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1] Output: 6
 * 
 * @author fachen
 *
 */
public class TrappingWater {
	public static int trap(int[] A) {
		int lo = 0;
		int hi = A.length - 1;
		int max = 0;
		int leftmax = 0;
		int rightmax = 0;
		while (lo <= hi) {
			leftmax = Math.max(leftmax, A[lo]);
			rightmax = Math.max(rightmax, A[hi]);
			if (leftmax < rightmax) {
				max += (leftmax - A[lo]);
				// leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
				lo++;
			} else {
				max += (rightmax - A[hi]);
				hi--;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] A = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		trap(A);
	}
}

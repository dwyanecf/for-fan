package com.fanchen.clearmind.zillow.VO;

public class FrogJump {
	public boolean canJump(int[] nums) {
		int cur = 0;
		for (int i = 0; i < nums.length; i++) {
			if (cur < i)
				return false;
			cur = Math.max(cur, nums[i] + i);
		}
		return true;
	}

	public int jump(int[] nums) {
		int far = 0;
		int cur = 0;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (cur >= nums.length - 1) {
				break;
			}
			far = Math.max(far, i + nums[i]);
			if (cur == i) {
				cur = far;
				count++;
			}
		}
		return count;
	}

	public boolean canCross(int[] stones) {
		int n = stones.length;
		boolean[][] dp = new boolean[n][n + 1];
		// from stone 0, whether can jump 1 step
		dp[0][1] = true;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				int distance = stones[i] - stones[j];
				if (distance > n || !dp[j][distance])
					continue;
				dp[i][distance] = true;
				if (distance - 1 >= 0) {
					dp[i][distance - 1] = true;
				}
				if (distance + 1 <= n) {
					dp[i][distance + 1] = true;
				}
				if (i == n - 1)
					return true;
			}
		}
		return false;
	}
}

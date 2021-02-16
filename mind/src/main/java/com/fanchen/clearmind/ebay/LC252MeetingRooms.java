package com.fanchen.clearmind.ebay;

import java.util.Arrays;

public class LC252MeetingRooms {
	public boolean canAttendMeetings(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
		for (int i = 0; i < intervals.length - 1; i++) {
			if (intervals[i][1] > intervals[i + 1][0]) {
				return false;
			}
		}
		return true;
	}
}

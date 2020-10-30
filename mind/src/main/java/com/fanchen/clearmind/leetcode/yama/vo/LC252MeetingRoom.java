package com.fanchen.clearmind.leetcode.yama.vo;

import java.util.Arrays;

import com.fanchen.clearmind.concept.Interval;

public class LC252MeetingRoom {

	/**
	 * Given an array of meeting time intervals consisting of start and end times
	 * [s1, e1], [s2, e2], ... , determine if a person could attend all meetings.
	 * 
	 * For example, Given [ [0, 30], [5, 10], [15, 20] ], return false.
	 * 
	 * 
	 * @param intervals
	 * @return
	 */
	public boolean canAttendMeetings(Interval[] intervals) {
		Arrays.sort(intervals, (a, b) -> a.start - b.start);

		for (int i = 0; i < intervals.length - 1; i++) {
			if (intervals[i].end > intervals[i + 1].start) {
				return false;
			}
		}

		return true;
	}
}

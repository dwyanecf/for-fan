package com.fanchen.clearmind.leetcode.yama.vo;

import java.util.Arrays;

import com.fanchen.clearmind.concept.Interval;

public class LC253MeetingRoom2 {

	/**
	 * Given an array of meeting time intervals consisting of start and end times
	 * [[s1,e1],[s2,e2],...] find the minimum number of conference rooms required.
	 * 
	 * 
	 * Given [[0, 30],[5, 10],[15, 20]], return 2.
	 * 
	 * @param intervals
	 * @return
	 */
	public int minMeetingRooms(Interval[] intervals) {
		int[] start = new int[intervals.length];
		int[] end = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			start[i] = intervals[i].start;
			end[i] = intervals[i].end;
		}
		Arrays.sort(start);
		Arrays.sort(end);
		int room = 0, pointer = 0;
		for (int i = 0; i < start.length; i++) {
			if (start[i] < end[pointer]) {
				room++;
			} else {
				pointer++;
			}
		}
		return room;
	}
	
	// need draw to picture
}

package com.fanchen.clearmind.zillow.VO;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (numCourses <= 0)
			return false;
		int[] needPreCourse = new int[numCourses];
		for (int[] pre : prerequisites) {
			needPreCourse[pre[0]]++;
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (needPreCourse[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int[] pre : prerequisites) {
				if (pre[1] == cur) {
					if (--needPreCourse[pre[0]] == 0) {
						q.offer(pre[0]);
					}
				}
			}
		}

		for (int i = 0; i < numCourses; i++) {
			if (needPreCourse[i] != 0) {
				return false;
			}
		}
		return true;
	}

}

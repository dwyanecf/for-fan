package com.fanchen.clearmind.leetcode.yama.vo;

import java.util.LinkedList;
import java.util.Queue;

public class LC210CourseSchedule2 {

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		if (numCourses <= 0)
			return null;
		int[] needPreCourse = new int[numCourses];
		int order[] = new int[numCourses];
		int index = 0;
		for (int[] pre : prerequisites) {
			needPreCourse[pre[0]]++;
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (needPreCourse[i] == 0) {
				q.offer(i);
				order[index++] = i;
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int[] pre : prerequisites) {
				if (pre[1] == cur) {
					if (--needPreCourse[pre[0]] == 0) {
						q.offer(pre[0]);
						order[index++] = pre[0];
					}
				}
			}
		}

		return index == numCourses ? order : new int[0];
	}
}

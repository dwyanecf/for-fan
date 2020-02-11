package com.fanchen.clearmind.lianjia;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
	public static boolean canFinish(int numCourses, int[][] prerequisites) {

		if (numCourses <= 0)
			return false;
		int[] toughCourse = new int[numCourses];
		for (int[] pre : prerequisites) {
			toughCourse[pre[0]]++;
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (toughCourse[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int easyCourse = q.poll();
			for (int[] pre : prerequisites) {
				if (pre[1] == easyCourse) {
					if (--toughCourse[pre[0]] == 0) {
						q.offer(pre[0]);
					}
				}
			}
		}
		for (int i = 0; i < numCourses; i++) {
			if (toughCourse[i] != 0) {
				return false;
			}
		}
		return true;

	}

	public static void main(String[] args) {
		int[][] prerequisites = new int[][] {{0,1}, {0,2},{1,3}};
		canFinish(4, prerequisites);
	}
}

package com.fanchen.clearmind.leetcode.ama;

import java.util.LinkedList;
import java.util.Queue;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * Example 1:
 * 
 * Input: 2, [[1,0]] Output: true Explanation: There are a total of 2 courses to
 * take. To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 * 
 * Input: 2, [[1,0],[0,1]] Output: false Explanation: There are a total of 2
 * courses to take. To take course 1 you should have finished course 0, and to
 * take course 0 you should also have finished course 1. So it is impossible.
 * Note:
 * 
 * The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented. You may
 * assume that there are no duplicate edges in the input prerequisites.
 * 
 * @author fachen
 *
 */
public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (numCourses <= 0)
			return false;
		int[] preCourseNum = new int[numCourses];
		for (int[] pre : prerequisites) {
			preCourseNum[pre[0]]++;
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (preCourseNum[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int[] pre : prerequisites) {
				if (pre[1] == cur) {
					if (--preCourseNum[pre[0]] == 0) {
						q.offer(pre[0]);
					}
				}
			}
		}
		for (int i = 0; i < numCourses; i++) {
			if (preCourseNum[i] != 0) {
				return false;
			}
		}
		return true;

	}
}

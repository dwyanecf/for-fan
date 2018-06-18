package com.fanchen.clearmind.leetcode.newproblems;

/**
 * In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty.
 *
 * There is at least one empty seat, and at least one person sitting.
 *
 * Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
 *
 * Return that maximum distance to closest person.
 *
 * Example 1:
 *
 * Input: [1,0,0,0,1,0,1]
 * Output: 2
 * Explanation:
 * If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
 * If Alex sits in any other open seat, the closest person has distance 1.
 * Thus, the maximum distance to the closest person is 2.
 * Example 2:
 *
 * Input: [1,0,0,0]
 * Output: 3
 * Explanation:
 * If Alex sits in the last seat, the closest person is 3 seats away.
 * This is the maximum distance possible, so the answer is 3.
 * Note:
 *
 * 1 <= seats.length <= 20000
 * seats contains only 0s or 1s, at least one 0, and at least one 1.
 */
public class MaximizeDistancetoClosestPerson {
    int max = Integer.MIN_VALUE;

    public int maxDistToClosest(int[] seats) {
        int dis = 0;
        int n = seats.length;
        int cur = 0;
        int pre = -1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                cur++;
            } else {
                if(pre == -1){
                    dis = i;
                }
                if (cur > max) {
                    max = cur;
                    dis = Math.max(dis, (i-pre)/2);
                }
                pre = i;
                cur = 0;
            }
        }
        return seats[n - 1] == 0 ? Math.max(n - 1 - pre, dis) : dis;
    }
}

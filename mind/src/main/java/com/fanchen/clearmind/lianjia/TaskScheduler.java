package com.fanchen.clearmind.lianjia;

import java.util.Arrays;

/**
 * Given a char array representing tasks CPU need to do.
 * It contains capital letters A to Z where different letters represent different tasks.
 * Tasks could be done without original order. Each task could be done in one interval.
 * For each interval, CPU could finish one task or just be idle.
 * <p>
 * However, there is a non-negative cooling interval n that means between two same tasks,
 * there must be at least n intervals that CPU are doing different tasks or just be idle.
 * <p>
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 * <p>
 * Example 1:
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 *
 * ABXXABXXABXXAB
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] table = new int[26];
        for (char c : tasks) {
            table[c - 'A']++;
        }
        Arrays.sort(table);
        int count = 0;
        int max = table[25];
        for (int j = 25; j >= 0; j--) {
            if (table[j] == max) {
                count++;
            }
        }
        return Math.max(tasks.length, (max - 1) * (n + 1) + count);
    }
}

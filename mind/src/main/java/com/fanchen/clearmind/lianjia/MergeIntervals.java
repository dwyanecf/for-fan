package com.fanchen.clearmind.lianjia;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
 */
class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return intervals;
        List<Interval> list = new ArrayList<>();
        intervals.sort((a, b) -> a.start - b.start);
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval cur : intervals) {
            if (cur.start <= end) {
                end = Math.max(end, cur.end);
            } else {
                Interval interval = new Interval(start, end);
                list.add(interval);
                start = cur.start;
                end = cur.end;
            }
        }
        list.add(new Interval(start, end));
        return list;
    }
}


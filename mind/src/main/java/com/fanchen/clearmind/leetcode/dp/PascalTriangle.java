package com.fanchen.clearmind.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Example:
 * <p>
 * Input: 5
 * Output:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int centerIndex = 1; centerIndex < row.size() - 1; centerIndex++) {
                row.set(centerIndex, row.get(centerIndex) + row.get(centerIndex + 1));
            }
            res.add(new ArrayList<>(row));
        }
        return res;
    }
}

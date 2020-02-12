/*
 * Copyright (C) 2019 Copart, Inc. All rights reserved.
 */
package com.fanchen.clearmind.leetcode.ama;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Fan Chen
 *
 */
public class MaxPointsLine {

	class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

	public int maxPoints(Point[] points) {
		if (points == null)
			return 0;
		if (points.length <= 2)
			return points.length;
		int max = 0;
		for (int i = 0; i < points.length; i++) {
			Map<BigDecimal, Integer> map = new HashMap<>();
			int sameP = 0;
			int sameX = 1;
			for (int j = 0; j < points.length; j++) {
				if (i != j) {
					if (points[i].x == points[j].x && points[i].y == points[j].y) {
						sameP++;
					}
					if (points[i].x == points[j].x) {
						sameX++;
						continue;
					}
					BigDecimal dx = new BigDecimal(points[j].x - points[i].x);
					BigDecimal dy = new BigDecimal(points[j].y - points[i].y);
					BigDecimal k = dy.divide(dx, MathContext.DECIMAL128);
					if (map.containsKey(k)) {
						map.put(k, map.get(k) + 1);
					} else {
						map.put(k, 2);
					}
					max = Math.max(max, map.get(k) + sameP);
				}
			}
			max = Math.max(max, sameX);
		}
		return max;
	}
}

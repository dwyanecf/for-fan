package com.fanchen.clearmind.zillow.VO;

import java.util.HashMap;
import java.util.Map;

public class LC166Fraction {
	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0)
			return "0";
		StringBuilder sb = new StringBuilder();
		if (numerator < 0 ^ denominator < 0) {
			sb.append("-");
		}
		long num = Math.abs((long) numerator);
		long den = Math.abs((long) denominator);

		sb.append(num / den);
		num %= den;
		if (num == 0) {
			return sb.toString();
		}
		sb.append(".");
		Map<Long, Integer> map = new HashMap<>();
		while (!map.containsKey(num)) {
			map.put(num, sb.length());
			num *= 10;
			sb.append(num / den);
			num %= den;
			if (num == 0)
				return sb.toString();
		}
		return sb.insert(map.get(num), "(").append(")").toString();
	}
}

package com.fanchen.clearmind.leetcode.map.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 *
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 *
 * Example 1:
 *
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 * Example 2:
 *
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 * Example 3:
 *
 * Input: numerator = 2, denominator = 3
 * Output: "0.(6)"
 */
public class FractiontoRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        if ((numerator > 0) ^ (denominator > 0)) sb.append("-");
        long num = Math.abs((long) numerator);
        long de = Math.abs((long) denominator);

        //integer part
        sb.append(num / de);
        num = num % de;
        if (num == 0) return sb.toString();

        //fraction part
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(num, sb.length());
        while (num != 0) {
            num = num * 10;
            sb.append(num / de);
            num = num % de;
            if (map.containsKey(num)) {
                int index = map.get(num);
                sb.insert(index, "(");
                sb.append(")");
                break;
            }
            map.put(num, sb.length());
        }
        return sb.toString();
    }
}

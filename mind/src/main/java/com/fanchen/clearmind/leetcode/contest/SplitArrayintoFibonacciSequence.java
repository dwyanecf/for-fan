package com.fanchen.clearmind.leetcode.contest;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string S of digits, such as S = "123456579", we can split it into a Fibonacci-like sequence [123, 456, 579].
 * <p>
 * Formally, a Fibonacci-like sequence is a list F of non-negative integers such that:
 * <p>
 * 0 <= F[i] <= 2^31 - 1, (that is, each integer fits a 32-bit signed integer type);
 * F.length >= 3;
 * and F[i] + F[i+1] = F[i+2] for all 0 <= i < F.length - 2.
 * Also, note that when splitting the string into pieces, each piece must not have extra leading zeroes, except if the piece is the number 0 itself.
 * <p>
 * Return any Fibonacci-like sequence split from S, or return [] if it cannot be done.
 * <p>
 * Example 1:
 * <p>
 * Input: "123456579"
 * Output: [123,456,579]
 * Example 2:
 * <p>
 * Input: "11235813"
 * Output: [1,1,2,3,5,8,13]
 * Example 3:
 * <p>
 * Input: "112358130"
 * Output: []
 * Explanation: The task is impossible.
 * Example 4:
 * <p>
 * Input: "0123"
 * Output: []
 * Explanation: Leading zeroes are not allowed, so "01", "2", "3" is not valid.
 * Example 5:
 * <p>
 * Input: "1101111"
 * Output: [110, 1, 111]
 * Explanation: The output [11, 0, 11, 11] would also be accepted.
 * Note:
 * <p>
 * 1 <= S.length <= 200
 * S contains only digits.
 */
public class SplitArrayintoFibonacciSequence {
    public List<Integer> splitIntoFibonacci(String S) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for (int fLen = 1; fLen <= 10 && fLen < S.length(); fLen++) {
            if (S.charAt(0) == '0' && fLen > 1) continue;
            for (int sLen = 1; sLen <= 10 && fLen + sLen <= S.length(); sLen++) {
                if (S.charAt(fLen) == '0' && sLen > 1) continue;
                long a = Long.parseLong(S.substring(0, fLen));
                long b = Long.parseLong(S.substring(fLen, fLen + sLen));
                StringBuilder sb = new StringBuilder();
                sb.append(a);
                sb.append(b);
                int inject = 2;
                while (sb.length() < S.length()) {
                    long c = a + b;
                    if (c > Integer.MAX_VALUE) {
                        sb.append(-1);
                        break;
                    }
                    inject++;
                    sb.append(c);
                    a = b;
                    b = c;
                }
                if (inject >= 3 && sb.toString().equals(S)) {
                    int aa = Integer.parseInt(S.substring(0, fLen));
                    int bb = Integer.parseInt(S.substring(fLen, fLen + sLen));
                    sb = new StringBuilder();
                    ret.add(aa);
                    ret.add(bb);
                    sb.append(aa);
                    sb.append(bb);
                    while (sb.length() < S.length()) {
                        int cc = aa + bb;
                        sb.append(cc);
                        ret.add(cc);
                        aa = bb;
                        bb = cc;
                    }
                    return ret;
                }
            }
        }
        return ret;
    }
}

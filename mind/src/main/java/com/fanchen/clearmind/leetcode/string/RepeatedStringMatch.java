package com.fanchen.clearmind.leetcode.string;

/**
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it.
 * If no such solution, return -1.
 * <p>
 * For example, with A = "abcd" and B = "cdabcdab".
 * <p>
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it;
 * and B is not a substring of A repeated two times ("abcdabcd").
 * <p>
 * Note:
 * The length of A and B will be between 1 and 10000.
 */
public class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder(A);
        for (int i = 1; i <= B.length() / A.length() + 2; i++) {
            if (sb.length() >= B.length() && sb.toString().indexOf(B) >=0) return i;
            sb.append(A);
        }
        return -1;
    }
}

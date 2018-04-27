package com.fanchen.clearmind.leetcode.string;

/**
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * The input strings are both non-empty and contains only characters 1 or 0.
 * <p>
 * Example 1:
 * <p>
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * <p>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        int indexA = aArray.length - 1;
        int indexB = bArray.length - 1;
        int sum = 0;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (indexA >= 0 || indexB >= 0) {
            sum = carry;
            if (indexA >= 0) {
                sum = sum + aArray[indexA--] - '0';
            }
            if (indexB >= 0) {
                sum = sum + bArray[indexB--] - '0';
            }
            carry = sum / 2;
            sum = sum % 2;
            sb.append(sum);
        }
        if (carry > 0) sb.append(carry);
        return sb.reverse().toString();
    }
}

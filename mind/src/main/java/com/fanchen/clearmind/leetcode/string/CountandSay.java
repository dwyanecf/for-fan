package com.fanchen.clearmind.leetcode.string;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth term of the count-and-say sequence.
 * <p>
 * Note: Each term of the sequence of integers will be represented as a string.
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: "1"
 * Example 2:
 * <p>
 * Input: 4
 * Output: "1211"
 */
public class CountandSay {
    public String countAndSay(int n) {
        StringBuilder res = new StringBuilder("1");
        //calculating each from 1 to n
        for (int i = 1; i < n; i++) {
            char[] pre = res.toString().toCharArray();
            //reset current string to empty
            res.setLength(0);
            int count = 1;
            //append each digit
            for (int j = 1; j < pre.length; j++) {
                if (pre[j - 1] == pre[j]) {
                    count++;
                } else {
                    res.append(count).append(pre[j - 1]);
                    count = 1;
                }
            }
            //append last digit
            res.append(count).append(pre[pre.length - 1]);
        }
        return res.toString();
    }
}

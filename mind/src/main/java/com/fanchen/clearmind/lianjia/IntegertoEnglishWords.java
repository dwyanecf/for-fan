package com.fanchen.clearmind.lianjia;

/**
 * Convert a non-negative integer to its english words representation.
 * Given input is guaranteed to be less than 231 - 1.
 *
 * Example 1:
 *
 * Input: 123
 * Output: "One Hundred Twenty Three"
 * Example 2:
 *
 * Input: 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * Example 3:
 *
 * Input: 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * Example 4:
 *
 * Input: 1234567891
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 */
public class IntegertoEnglishWords {
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String[] lessThan20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tenthWord = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] deWord = {"Billion", "Million", "Thousand", "Hundred"};
        int[] radix = {1000000000, 1000000, 1000, 100};
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < radix.length; i++) {
            count = num / radix[i];
            if (count == 0) continue;
            sb.append(numberToWords(count) + " ");
            sb.append(deWord[i] + " ");
            num %= radix[i];
        }
        if (num < 20) {
            sb.append(lessThan20[num]);
        } else {
            sb.append(tenthWord[num / 10 - 2] + " ");
            sb.append(lessThan20[num % 10]);
        }
        return sb.toString().trim();
    }
}

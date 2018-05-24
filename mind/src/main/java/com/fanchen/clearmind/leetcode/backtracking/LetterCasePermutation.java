package com.fanchen.clearmind.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string S, we can transform every letter individually
 * to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.
 * <p>
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 * <p>
 * Input: S = "12345"
 * Output: ["12345"]
 * Note:
 * <p>
 * S will be a string with length at most 12.
 * S will consist only of letters or digits.
 */
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        helper(S, res, 0);
        return res;
    }

    private void helper(String s, List<String> res, int pos) {
        if (pos == s.length()) {
            res.add(s);
            return;
        }
        char[] charS = s.toCharArray();
        if (charS[pos] >= '0' && charS[pos] <= '9') {
            helper(s, res, pos + 1);
            return;
        }
        charS[pos] = Character.toLowerCase(charS[pos]);
        helper(String.valueOf(charS), res, pos + 1);
        charS[pos] = Character.toUpperCase(charS[pos]);
        helper(String.valueOf(charS), res, pos + 1);
    }
}

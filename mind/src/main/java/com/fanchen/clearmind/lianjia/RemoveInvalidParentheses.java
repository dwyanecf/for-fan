package com.fanchen.clearmind.lianjia;

import java.util.ArrayList;
import java.util.List;

/**
 * Remove the minimum number of invalid parentheses in order to make the input string valid.
 * Return all possible results.
 *
 * Note: The input string may contain letters other than the parentheses ( and ).
 *
 * Example 1:
 *
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 * Example 2:
 *
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 * Example 3:
 *
 * Input: ")("
 * Output: [""]
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> list = new ArrayList<>();
        helper(list, s, new char[]{'(', ')'}, 0, 0);
        return list;
    }

    private void helper(List<String> list, String s, char[] brackets, int indexI, int indexJ) {
        for (int count = 0, i = indexI; i < s.length(); i++) {
            if (s.charAt(i) == brackets[0]) count++;
            if (s.charAt(i) == brackets[1]) count--;
            if (count >= 0) continue;
            for (int j = indexJ; j <= i; j++) {
                if (s.charAt(j) == brackets[1] && (j == indexJ || s.charAt(j - 1) != brackets[1])){
                    helper(list, s.substring(0,j) + s.substring(j+1, s.length()), brackets, i, j);
                }
            }
            return;
        }
        String reversedS = new StringBuilder(s).reverse().toString();
        if (brackets[0] == '(') {
            helper(list, reversedS, new char[]{')', '('}, 0, 0);
        } else {
            list.add(reversedS);
        }
    }
}

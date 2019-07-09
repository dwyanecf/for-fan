package com.fanchen.clearmind.leetcode.newproblems;

import java.util.ArrayList;
import java.util.List;

/**
 * In a string S of lowercase letters, these letters form consecutive groups of the same character.
 *
 * For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".
 *
 * Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.
 *
 * The final answer should be in lexicographic order.
 *
 *
 *
 * Example 1:
 *
 * Input: "abbxxxxzzy"
 * Output: [[3,6]]
 * Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
 * Example 2:
 *
 * Input: "abc"
 * Output: []
 * Explanation: We have "a","b" and "c" but no large group.
 * Example 3:
 *
 * Input: "abcdddeeeeaabbbcd"
 * Output: [[3,5],[6,9],[12,14]]
 *
 *
 * Note:  1 <= S.length <= 1000
 */
public class PositionsofLargeGroups {
    public List<List<Integer>> largeGroupPositions(String S) {
        if(S.length() < 3) return new ArrayList<>();
        char[] c = S.toCharArray();
        List<List<Integer>> res = new ArrayList<>();
        int startIndex = 0;
        List<Integer> cur = new ArrayList<>();
        cur.add(startIndex);
        int count = 1;
        for(int i =0; i < c.length -1;i++){
            if(c[i] == c[i+1]){
                count++;
                if(i == c.length -2 && count>=3){
                    cur.add(i+1);
                    res.add(new ArrayList<>(cur));
                    break;
                }
            }else {
                if(count >= 3){
                    cur.add(i);
                    res.add(new ArrayList<>(cur));
                }
                cur.clear();
                cur.add(i+1);
                count = 1;
            }
        }
        return res;
    }
    //"bababbaaab"
}

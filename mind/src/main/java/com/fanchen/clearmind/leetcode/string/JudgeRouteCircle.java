package com.fanchen.clearmind.leetcode.string;

/**
 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves,
 * judge if this robot makes a circle, which means it moves back to the original place.
 * <p>
 * The move sequence is represented by a string. And each move is represent by a character.
 * The valid robot moves are R (Right), L (Left), U (Up) and D (down).
 * The output should be true or false representing whether the robot makes a circle.
 * <p>
 * Example 1:
 * Input: "UD"
 * Output: true
 * Example 2:
 * Input: "LL"
 * Output: false
 */
public class JudgeRouteCircle {
    public boolean judgeCircle(String moves) {
        int[] res = new int[2];
        for (Character c : moves.toCharArray()) {
            switch (c) {
                case 'U':
                    res[0]++;
                    break;
                case 'D':
                    res[0]--;
                    break;
                case 'L':
                    res[1]++;
                    break;
                case 'R':
                    res[1]--;
                    break;
            }
        }
        return res[0] == 0 && res[1] == 0;
    }
}

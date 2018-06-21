package com.fanchen.clearmind.leetcode.newproblems;

import java.util.HashMap;
import java.util.Map;

/**
 * Alice has a hand of cards, given as an array of integers.
 * <p>
 * Now she wants to rearrange the cards into groups so that each group is size W,
 * and consists of W consecutive cards.
 * <p>
 * Return true if and only if she can.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
 * Output: true
 * Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
 * Example 2:
 * <p>
 * Input: hand = [1,2,3,4,5], W = 4
 * Output: false
 * Explanation: Alice's hand can't be rearranged into groups of 4.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= hand.length <= 10000
 * 0 <= hand[i] <= 10^9
 * 1 <= W <= hand.length
 */
public class HandofStraights {
    public boolean isNStraightHand(int[] hand, int W) {
        if (W == 1) return true;
        int n = hand.length;
        if (n % W != 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Integer key : map.keySet()) {
            if(map.get(key) > 0){
                for(int i = W-1; i>=0 ;i--){
                    if(map.getOrDefault(key+i,0)<map.get(key)) return false;
                    map.put(key+i, map.get(key+i) - map.get(key));
                }
            }
        }
        return true;
    }
}

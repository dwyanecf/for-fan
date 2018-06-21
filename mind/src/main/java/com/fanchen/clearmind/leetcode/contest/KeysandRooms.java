package com.fanchen.clearmind.leetcode.contest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.
 * <p>
 * Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.
 * <p>
 * Initially, all the rooms start locked (except for room 0).
 * <p>
 * You can walk back and forth between rooms freely.
 * <p>
 * Return true if and only if you can enter every room.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1],[2],[3],[]]
 * Output: true
 * Explanation:
 * We start in room 0, and pick up key 1.
 * We then go to room 1, and pick up key 2.
 * We then go to room 2, and pick up key 3.
 * We then go to room 3.  Since we were able to go to every room, we return true.
 * Example 2:
 * <p>
 * Input: [[1,3],[3,0,1],[2],[0]]
 * Output: false
 * Explanation: We can't enter the room with number 2.
 * Note:
 * <p>
 * 1 <= rooms.length <= 1000
 * 0 <= rooms[i].length <= 1000
 * The number of keys in all rooms combined is at most 3000.
 */
public class KeysandRooms {
    public Set<Integer> keySet;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int len = rooms.size();
        if (len == 1) return true;
        Set<Integer> allRooms = new HashSet<>();
        for (int i = 1; i < len; i++) {
            allRooms.add(i);
        }
        keySet = new HashSet<>();
        keySet.addAll(rooms.get(0));
        populateKeySet(rooms);

        for (Integer key : keySet) {
            allRooms.remove(key);
        }
        return allRooms.isEmpty();

    }

    private void populateKeySet(List<List<Integer>> rooms) {
        int curSize = keySet.size();
        List<Integer> res = new ArrayList<>();
        for (Integer key : keySet) {
            List<Integer> newKeys = rooms.get(key);
            for(Integer newKey: newKeys){
                if (!keySet.contains(newKey)){
                    res.add(newKey);
                }
            }
        }
        if(res.size()>0){
            keySet.addAll(res);
        }
        if (keySet.size() > curSize) {
            populateKeySet(rooms);
        }
    }

}

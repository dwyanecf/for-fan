package com.fanchen.clearmind.lianjia;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] cur = str.toCharArray();
            Arrays.sort(cur);
            String mapKey = String.valueOf(cur);
            if (!map.containsKey(mapKey)) {
                map.put(mapKey, new ArrayList<>());
            }
            map.get(mapKey).add(str);
        }
        return new ArrayList<>(map.values());
    }
}

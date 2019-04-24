package com.fanchen.clearmind.concept;

import java.util.Map;
import java.util.TreeMap;

public class Snapshot {
    int length;
    int version = 1;
    Map<Integer, TreeMap<Integer, Integer>> map;

    public Snapshot(int length) {
        this.length = length;
        for (int i = 0; i < length; i++) {
            map.put(i, new TreeMap<>());
        }
    }

    public Snapshot() {
        version++;
    }

    public void set(int index, int val) {
        map.get(index).put(version, val);
    }

    public int get(int index, int version) {
        Integer key = map.get(index).floorKey(version);
        if (key == null) return Integer.MIN_VALUE;
        return map.get(index).get(key);
    }
}

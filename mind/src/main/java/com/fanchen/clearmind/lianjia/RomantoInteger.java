package com.fanchen.clearmind.lianjia;

import java.util.HashMap;
import java.util.Map;

public class RomantoInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int i = 0; i < s.length() - 1; i++) {
            int cur = map.get(s.charAt(i));
            if (cur < map.get(s.charAt(i + 1))) {
                res = res - cur;
            } else {
                res = res + cur;
            }
        }
        res = res + map.get(s.charAt(s.length() - 1));
        return res;
    }
}

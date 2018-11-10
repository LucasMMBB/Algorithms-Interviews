package com.practiceproblems.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    给一个string, 一个数字k， 要求找到这个string中所有的substring，满足每一个substring都是k的长度并且是k个不同的字母。
 */

public class OA_10_24_2018_5 {
    public List<String> findAllSubstring(String s, int k) {
        List<String> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int distinctCharInWindow = 0;

        for(int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if(i >= k) {
                char prev = s.charAt(i - k);

                map.put(prev, map.get(prev) - 1);
                if(map.get(prev) == 0) {
                    distinctCharInWindow--;
                }

            }

            map.put(current, map.getOrDefault(current, 0) + 1);
            if(map.get(current) == 1) {
                distinctCharInWindow++;
            }

            if(distinctCharInWindow == k) {
                list.add(s.substring(i - k + 1, i + 1));
            }
        }

        return list;
    }

    public static void main(String[] args) {
        OA_10_24_2018_5 solution = new OA_10_24_2018_5();
        String s = "abcddddddd";
        int k = 4;

        for(String string : solution.findAllSubstring(s, k)) {
            System.out.println(string);
        }
    }
}

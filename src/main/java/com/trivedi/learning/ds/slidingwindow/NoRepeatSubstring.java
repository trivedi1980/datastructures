package com.trivedi.learning.ds.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NoRepeatSubstring {
    public static void main(String[] args) {
        System.out.println(noRepeatSubstring("aabccbb"));
        System.out.println(noRepeatSubstring("abbbb"));
    }

    private static int noRepeatSubstring(String s) {
        int ws = 0;
        int we= 0;
        Map<Character, Integer> map = new HashMap<>();
        int length = 0;
        while (we < s.length()) {
            char ch = s.charAt(we);
            if (map.containsKey(ch)) {
                length = Math.max(length, we - ws);
                int chIndex = map.get(ch);
                for (int i = ws; i < chIndex; i++) {
                    map.remove(s.charAt(i));
                }
            }
            map.put(ch, we);
            we++;
        }
        length = Math.max(length, we - ws);
        return length;
    }
}

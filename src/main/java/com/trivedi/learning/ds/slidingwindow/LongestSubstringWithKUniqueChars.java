package com.trivedi.learning.ds.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniqueChars {
    public static void main(String[] args) {
        System.out.println(longestSubstringWithKUniqueChars("araaci", 2));
    }

    private static int longestSubstringWithKUniqueChars(String s, int k) {
        int ws = 0;
        int we = 0;
        Map<Character, Integer> charFreq = new HashMap<>();
        int i = 0;
        while (charFreq.keySet().size() > k) {
            char ch = s.charAt(i);
            charFreq.put(ch, charFreq.getOrDefault(ch, 0) + 1);
            i++;
        }

        int length = 0;
        we = i - 1;
        while (we < s.length()) {
            if (charFreq.keySet().size() > k) {
                length = Math.max(length, we - ws);
                char ch = s.charAt(ws);
                ws++;
                charFreq.put(ch, charFreq.get(ch) - 1);
                if (charFreq.get(ch) == 0) {
                    charFreq.remove(ch);
                }
            } else {
                we++;
                if (we < s.length()) {
                    char ch = s.charAt(we);
                    charFreq.put(ch, charFreq.getOrDefault(ch, 0) + 1);
                }
            }
        }
        return length;
    }
}

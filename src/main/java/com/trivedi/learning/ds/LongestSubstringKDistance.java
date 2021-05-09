package com.trivedi.learning.ds;

import java.util.*;

class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
        if (str.length() == 0) return 0;

        int length = 0;
        int start = 0;
        int end = 0;
        Map<Character, Integer> refCount = new HashMap<>();
        refCount.put(str.charAt(start), 1);

        while (end < str.length()) {
            if (refCount.keySet().size() > k) {
                length = Math.max(length, end - start);
                char ch = str.charAt(start);
                start++;
                int count = refCount.get(ch);
                if (count - 1 == 0) {
                    refCount.remove(ch);
                } else {
                    refCount.put(ch, count -1);
                }
            } else {
                end++;
                if (end < str.length()) {
                    char ch = str.charAt(end);
                    refCount.put(ch, refCount.getOrDefault(ch, 0) + 1);
                }
            }
        }
        if (refCount.keySet().size() > k) {
            length = Math.max(length, end - start);
        }

        return length;
    }
}


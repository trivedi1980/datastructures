package com.trivedi.learning.ds.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {
    public static void main(String[] args) {
        System.out.println(findLength(new char[] {'A', 'B', 'C', 'B', 'C'}));
    }
    public static int findLength(char[] arr) {
        int ws = 0;
        int k = 2;
        Map<Character, Integer> charFreq = new HashMap<>();
        int length = 0;
        int we = -1;
        while (we < arr.length) {
            if (charFreq.keySet().size() > k) {
                length = Math.max(length, we - ws);
                char ch = arr[ws];
                ws++;
                charFreq.put(ch, charFreq.get(ch) - 1);
                if (charFreq.get(ch) == 0) {
                    charFreq.remove(ch);
                }
            } else {
                we++;
                if (we < arr.length) {
                    char ch = arr[we];
                    charFreq.put(ch, charFreq.getOrDefault(ch, 0) + 1);
                }
            }
        }
        if (charFreq.keySet().size() > 0) {
            length = Math.max(length, we-ws);
        }
        return length;
    }
}

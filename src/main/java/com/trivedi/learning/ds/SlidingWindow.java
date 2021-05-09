package com.trivedi.learning.ds;

import java.util.*;

public class SlidingWindow {
    public static List<Float> avgOfAllContiguousSubArrays(int[] array, int k) {
        List<Float> list = new ArrayList<>();
        for (int i = 0; (array.length - i - k) >=0 ; i++) {
            int value = 0;
            for (int j = 0; j < 5; j++) {
                value = value + array[i + j];
            }
            list.add(value/5.0f);
        }
        return list;
    }

    public static float[] avgOfAllContiguousSubArrays2(int[] array, int k) {
        float[] avgs = new float[array.length - k + 1];
        int total = 0;
        for (int i = 0; i < k; i++) {
            total = total + array[i];
        }
        avgs[0] = total / 5.0f;

        for (int i = 1; i < array.length - k + 1; i++) {
            total = total - array[i-1] + array[i + k - 1];
            avgs[i] = total / 5.0f;
        }
        return avgs;
    }

    public static int maxSumOfAnyContiguousSubArray(int[] array, int k) {
        int total = 0;
        for (int i = 0; i < k; i++) {
            total = total + array[i];
        }
        int max = total;
        for (int i = 1; i < (array.length - k + 1); i++) {
            total = total - array[i -1] + array[i + k -1];
            if (max < total) {
                max = total;
            }
        }
        return max;
    }

    public static int smallestSubArrayWithGivenSum(int[] a, int sum) {
        int total = 0;
        int length = 0;
        for (int i = 0; i < a.length; i++) {
            total = total + a[i];
            if (total >= sum) {
                length = i + 1;
                break;
            }
        }

        if (length <= 1) return length;

        int start = 0;
        int end = length - 1;

        while (start <= end && end < a.length) {
            if (total >= sum) {
                length = Math.min(length, end - start  + 1);
                total = total - a[start];
                start++;
            } else {
                end++;
                if (end < a.length)
                    total = total + a[end];
            }
        }
        return length;
    }

    public static int longestSubStringWithKUniqueChars(String string, int k) {
        char[] chars = string.toCharArray();
        int len = 0;
        Set<Character> charSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            sb.setLength(0);
            charSet.clear();
            for (int j = i; j < chars.length; j++) {
                sb.append(chars[j]);
                charSet.add(chars[j]);
                if (charSet.size() > k) {
                    break;
                } else {
                    len = Math.max(len, sb.length());
                }
            }
        }
        return len;
    }

    public static int longestSubStringWithKUniqueChars2(String string, int k) {
        char[] chars = string.toCharArray();
        Map<Character, Integer> windowChars = new HashMap<>();

        int windowStart = 0;
        int windowEnd = 0;
        for (int i = 0; i < chars.length; i++) {
            if (windowChars.keySet().size() == k) {
                windowEnd = i - 1;
                break;
            } else {
                if (windowChars.containsKey(chars[i])) {
                    windowChars.replace(chars[i], windowChars.get(chars[i]) + 1);
                } else {
                    windowChars.put(chars[i], 1);
                }
            }
        }
        int length = 0;

        while (windowEnd < chars.length) {
            char ch;
            if (windowChars.keySet().size() > k) {
                length = Math.max(length, windowEnd - windowStart);
                // shrink the window
                ch = chars[windowStart];
                windowStart++;
                int count = windowChars.get(ch) - 1;
                if (count == 0) {
                    windowChars.remove(ch);
                } else {
                    windowChars.replace(ch, count);
                }
            } else {
                // slide window to right
                windowEnd++;
                if (windowEnd < chars.length) {
                    ch = chars[windowEnd];
                    if (windowChars.containsKey(ch)) {
                        windowChars.replace(ch, windowChars.get(ch) + 1);
                    } else {
                        windowChars.put(ch, 1);
                    }
                }
            }
        }
        return length;
    }

    public static int longestSubStringNoRepeat(String string) {
        char[] chars = string.toCharArray();
        Set<Character> uniqueSet = new HashSet<>();
        int length = 0;
        for (int i = 0; i < chars.length; i++) {
            uniqueSet.clear();
            for (int j = i; j < chars.length; j++) {
                if (uniqueSet.contains(chars[j])) {
                    break;
                }
                uniqueSet.add(chars[j]);
            }
            length = Math.max(length, uniqueSet.size());
        }
        return length;
    }

    public static int longestSubStringNoRepeat2(String string) {
        char[] chars = string.toCharArray();
        int length = 0;
        int s = 0;
        int e = 0;
        Map<Character, Integer> charIndex = new HashMap<>();
        charIndex.put(chars[s], s);

        while (e+1 < chars.length) {
            e++;
            if (charIndex.containsKey(chars[e])) {
                length = Math.max(length, e - s);
                s = charIndex.get(chars[e]) + 1;
                e = s;
                charIndex.clear();
                charIndex.put(chars[s], s);
            } else {
                charIndex.put(chars[e], e);
            }
        }
        length = Math.max(length, e - s);
        return length;
    }

    public static int longestSubStringWithSameLettersAfterReplacement(String str, int k) {
        char[] chars = str.toCharArray();
        int value = 0;
        for (int i = 0; i < chars.length; i++) {
            int dist = 0;
            int length = 0;
            for (int j = i; j < chars.length; j++) {
                if (chars[i] != chars[j]) {
                    dist++;
                    if (dist > k) {
                        length = length - 1;
                        break;
                    }
                }
                length++;
            }
            value = Math.max(value, length);
        }
        return value;
    }
}

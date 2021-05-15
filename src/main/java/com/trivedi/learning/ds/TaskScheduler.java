package com.trivedi.learning.ds;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            freq.put(tasks[i], freq.getOrDefault(tasks[i], 0)  + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (Character key : freq.keySet()) {
            maxHeap.offer(freq.get(key));
        }

        int maxValue = maxHeap.peek();
        int maxValueCount = 0;

        for (Character key : freq.keySet()) {
            if (maxValue == freq.get(key)) {
                maxValueCount++;
            }
        }

        return ((maxValue - 1) * (n + 1)) + maxValueCount;
    }

    public static void main(String[] args) {
        System.out.println(leastInterval(new char[] { 'A','A','A','B','B','B'}, 2));
    }
}

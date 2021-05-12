package com.trivedi.learning.ds.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMax {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            maxHeap.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            result[i - k] = maxHeap.peek();
            maxHeap.remove(nums[i-k]);
            maxHeap.offer(nums[i]);
        }
        result[nums.length - k] = maxHeap.peek();
        return result;
    }
}

package com.trivedi.learning.ds.cyclic;

import java.util.Arrays;

public class CyclicSort {
    public static int[] sort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i + 1) {
                i++;
            } else {
                swap(nums, i, nums[i] - 1);
            }
        }
        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[] {3, 1, 5, 4, 2})));
        System.out.println(Arrays.toString(sort(new int[] {2, 6, 4, 3, 1, 5})));
        System.out.println(Arrays.toString(sort(new int[] {1, 5, 6, 4, 3, 2})));
    }
}

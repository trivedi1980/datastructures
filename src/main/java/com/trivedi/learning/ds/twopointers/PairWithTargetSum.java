package com.trivedi.learning.ds.twopointers;

import java.util.Arrays;

public class PairWithTargetSum {
    public static void main(String[] args) {
        int[] pair = search(new int[] {1, 2, 3, 4, 6}, 6);
        System.out.println("pair is: [" + pair[0] + ", " + pair[1] + "]");
        pair = search(new int[] {2, 5, 9, 11}, 11);
        System.out.println("pair is: [" + pair[0] + ", " + pair[1] + "]");
    }

    private static int[] search(int[] nums, int sum) {
        int[] pair = new int[] { -1, -1 };
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int temp = nums[i] + nums[j];
            if (temp == sum) {
                pair[0] = i;
                pair[1] = j;
                break;
            } else if (temp > sum) {
                j--;
            } else {
                i++;
            }
        }
        return pair;
    }
}

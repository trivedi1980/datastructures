package com.trivedi.learning.ds.cyclic;

import java.util.ArrayList;
import java.util.List;

public class FindAllMissingNumbers {
    public static void main(String[] args) {
        System.out.println(findMissingNumbers(new int[] {2, 3, 1, 8, 2, 3, 5, 1}));
        System.out.println(findMissingNumbers(new int[] {2, 4, 1, 2})); 
    }

    private static List<Integer> findMissingNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i+1 && nums[i] -1 < nums.length & nums[i] != nums[nums[i] -1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }

        List<Integer> missing = new ArrayList<>();
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) {
                missing.add(i+1);
            }
        }
        return missing;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

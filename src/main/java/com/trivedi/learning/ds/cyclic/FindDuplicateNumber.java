package com.trivedi.learning.ds.cyclic;

public class FindDuplicateNumber {
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[] {1, 4, 4, 3, 2}));
        System.out.println(findDuplicate(new int[] {2, 1, 3, 3, 5, 4}));
    }

    private static int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i+1 && nums[i] -1 < nums.length & nums[i] != nums[nums[i] -1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) {
                return nums[i];
            }
        }
        return -1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

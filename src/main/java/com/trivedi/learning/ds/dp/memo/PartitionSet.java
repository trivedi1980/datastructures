package com.trivedi.learning.ds.dp.memo;

public class PartitionSet {
    public static boolean canPartition(int[] nums) {
        if (nums.length == 0) return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;

        int result = sum / 2;
        return canPartition(nums, 0, result);
    }

    private static boolean canPartition(int[] nums, int index, int sum) {
        if (index >= nums.length) return false;
        if (sum < 0) return false;
        if (nums[index] == sum) return true;

        return canPartition(nums, index + 1, sum - nums[index])
                || canPartition(nums, index + 1, sum);
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[] { 1, 1, 3, 4, 7 }));
        System.out.println(canPartition(new int[] { 1, 2, 3, 4 }));
        System.out.println(canPartition(new int[] { 2, 2, 2, 2, 2, 2, 2, 2,2,2,2,2,2,2,2,2,2,2, 2, 2, 2, 2, 2, 2, 2,2,2,2,2,2,2,2,2,2}));
    }
}

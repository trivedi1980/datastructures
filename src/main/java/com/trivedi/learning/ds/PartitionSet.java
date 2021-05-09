package com.trivedi.learning.ds;

class PartitionSet {

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) return false;

        int subArrayCount = sum / 2;
        return canPartition(nums, subArrayCount, 0);
    }

    public static boolean canPartition(int[] nums, int sum, int index) {
        if (index >= nums.length || sum <= 0) return false;

        if (nums[index] == sum) return true;

        return canPartition(nums, sum - nums[index], index + 1)
                || canPartition(nums, sum, index + 1);
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[] { 2, 3, 4, 6 }));
    }
}

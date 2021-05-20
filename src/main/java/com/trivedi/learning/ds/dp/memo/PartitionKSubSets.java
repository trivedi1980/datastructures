package com.trivedi.learning.ds.dp.memo;

import java.util.Arrays;

public class PartitionKSubSets {
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length == 0) return false;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % k != 0) return false;

        Arrays.sort(nums);
        int count = getPartitionSubsetsWithSum(nums, sum / k, 0);
        return count == k;
    }

    private static int getPartitionSubsetsWithSum(int[] nums, int sum, int index) {
        if (index >= nums.length) return 0;
        if (sum < 0) return 0;
        if (nums[index] > sum) return 0;
        if (nums[index] == sum) return 1;

        return getPartitionSubsetsWithSum(nums, sum - nums[index], index +1) +
                getPartitionSubsetsWithSum(nums, sum , index + 1);
    }

    public static void main(String[] args) {
        System.out.println(canPartitionKSubsets(new int[] {4,3,2,3,5,2,1}, 4));
    }
}

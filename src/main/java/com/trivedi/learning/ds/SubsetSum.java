package com.trivedi.learning.ds;

class SubsetSum {

    public boolean canPartition(int[] nums, int sum) {
        Boolean[][] dp = new Boolean[nums.length][sum + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }

        for (int s = 0; s<= sum; s++) {
            dp[0][s] = nums[0] == s ? true : false;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int s = 1; s <= sum; s++) {
                if (s - nums[i] >= 0)
                    dp[i][s] = dp[i-1][s - nums[i]] || dp[i -1][s];
                else
                    dp[i][s] = dp[i-1][s];
            }
        }
        return dp[nums.length - 1][sum];
    }

    public static void main(String[] args) {
        SubsetSum ss = new SubsetSum();
        int[] num = { 1, 2, 3, 7 };
        System.out.println(ss.canPartition(num, 6));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.canPartition(num, 10));
        num = new int[] { 1, 3, 4, 8 };
        System.out.println(ss.canPartition(num, 6));
    }
}

package com.trivedi.learning.ds;

import java.util.*;

class Solution {
    public static boolean canPartition(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        if (sum % 2 != 0) return false;

        int arrayCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int length = subsets.size();
            for (int j = 0; j < length; j++) {
                List<Integer> list = new ArrayList<>(subsets.get(j));
                list.add(nums[i]);
                int s = 0;
                for (int k = 0; k < list.size(); k++) {
                    s += list.get(k);
                }
                if (s <= sum / 2) {
                    subsets.add(list);
                }

                if (s == sum / 2) {
                    arrayCount++;
                }
            }
        }
        return arrayCount == 2;
    }

    public static void main(String[] args) {
        canPartition(new int[] {1, 1, 1, 1});
    }
}

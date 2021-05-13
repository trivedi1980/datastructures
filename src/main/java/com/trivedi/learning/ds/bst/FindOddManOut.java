package com.trivedi.learning.ds.bst;

public class FindOddManOut {
    public static int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[nums.length -1] != nums[nums.length -2]) return nums[nums.length -1];
        return search(nums, 0, nums.length - 1);
    }

    private static int search(int[] nums, int start, int end) {
        int mid = start + (end - start) / 2;

        if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid -1]) return nums[mid];

        if ((mid % 2 == 0 && nums[mid] == nums[mid+1])
                || (mid % 2 ==1 && nums[mid] == nums[mid-1])) {
            return search(nums, mid+1, end);
        } else {
            return search(nums, start, mid);
        }
    }

    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[] {1,1,2}));
    }
}

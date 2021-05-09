package com.trivedi.learning.ds.slidingwindow;


public class SmallestSubArrayWithGivenSum {
    public static void main(String[] args) {
        System.out.println(smallestSubArrayWithGivenSum(new int[] {2, 1, 5, 2, 3, 2}, 7));
        System.out.println(smallestSubArrayWithGivenSum(new int[] {2, 1, 5, 2, 8}, 8));
        System.out.println(smallestSubArrayWithGivenSum(new int[] {3, 4, 1, 1, 6}, 8));
    }

    private static int smallestSubArrayWithGivenSum(int[] arr, int target) {
        int ws = 0;
        int we = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum >= target) {
                we = i;
                break;
            }
        }

        int length = Integer.MAX_VALUE;
        while (we < arr.length) {
            if (sum >= target) {
                length = Math.min(length, (we - ws + 1));
                sum -= arr[ws];
                ws++;
            } else {
                we++;
                if (we < arr.length)
                    sum += arr[we];
            }
        }
        return length;
    }
}

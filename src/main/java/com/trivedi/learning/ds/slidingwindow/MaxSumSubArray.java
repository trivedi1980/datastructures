package com.trivedi.learning.ds.slidingwindow;

public class MaxSumSubArray {
    public static void main(String[] args) {
        System.out.println(maxSumSubArray(new int[] {2, 1, 5, 1, 3, 2}, 3));
    }

    private static int maxSumSubArray(int[] arr, int k) {
        if (arr.length == 0 || arr.length < k) return 0;
        int sum = 0;
        int ws = 0;
        int we = k -1;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int wSum = sum;
        while (we < arr.length) {
            sum = Math.max(sum, wSum);
            wSum -= arr[ws++];
            we++;
            if (we < arr.length) {
                wSum += arr[we];
            }
        }
        return sum;
    }
}

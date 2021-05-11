package com.trivedi.learning.ds.dp.memo;

public class MaxSubArray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] { -2,1,-3,4,-1,2,1,-5,4}));
    }

    private static int maxSubArray(int[] arr) {
        int[] tab = new int[arr.length];
        tab[0] = arr[0];
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            tab[i] = Math.max(arr[i], arr[i] + tab[i - 1]);
            max = Math.max(max, tab[i]);
        }
        return max;
    }
}

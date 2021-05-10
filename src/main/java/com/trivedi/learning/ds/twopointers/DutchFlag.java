package com.trivedi.learning.ds.twopointers;

import java.util.Arrays;

public class DutchFlag {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[] { 1, 0, 2, 1, 0 })));
        System.out.println(Arrays.toString(sort(new int[] { 2, 2, 0, 1, 2, 0 })));
    }

    public static int[] sort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int i = 1;
        while (i <= right) {
            if (arr[i] == 0) {
                swap(arr, left, i);
                left++;
            } else if (arr[i] == 2) {
                swap(arr, right, i);
                right--;
            } else {
                i++;
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        if (arr[i] != arr[j]) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}

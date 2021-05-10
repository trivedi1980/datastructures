package com.trivedi.learning.ds.twopointers;

import java.util.Arrays;

public class SquaringSortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(square(new int[] {-2, -1, 0, 2, 3})));
        System.out.println(Arrays.toString(square(new int[] {-3, -1, 0, 1, 2})));
    }

    private static int[] square(int[] arr) {
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 1;
        int[] sq = new int[arr.length];
        int index = arr.length - 1;
        while (i <= j) {
            int s1 = arr[i] * arr[i];
            int s2 = arr[j] * arr[j];
            if (s1 > s2) {
                sq[index] = s1;
                i++;
            } else {
                sq[index] = s2;
                j--;
            }
            index--;
        }
        return sq;
    }
}

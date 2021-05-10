package com.trivedi.learning.ds.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {
    public static void main(String[] args) {
        System.out.println(searchTriplets(new int[] {-3, 0, 1, 2, -1, 1, -2}));
    }

    private static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            while (left <= right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[i]);
                    list.add(arr[left]);
                    list.add(arr[right]);
                    results.add(list);
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return results;
    }
}

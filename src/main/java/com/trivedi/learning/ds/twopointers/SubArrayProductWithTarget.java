package com.trivedi.learning.ds.twopointers;

import java.util.ArrayList;
import java.util.List;

public class SubArrayProductWithTarget {
    public static void main(String[] args) {
        System.out.println(subArrayProductsWithTarget(new int[] { 2, 5, 3, 10}, 30));
    }
    private static List<List<Integer>> subArrayProductsWithTarget(int[] arr, int target) {
        List<List<Integer>> results = new ArrayList<>();
        int prod = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= target) continue;

            List<Integer> list = new ArrayList<>();
            list.add(arr[i]);
            results.add(new ArrayList<>(list));
            prod = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                prod = prod * arr[j];
                if (prod < target) {
                    list.add(arr[j]);
                } else {
                    break;
                }
            }

            if (list.size() > 1) {
                results.add(list);
            }
        }
        return results;
    }
}

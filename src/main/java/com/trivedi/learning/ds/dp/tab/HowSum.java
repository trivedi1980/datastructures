package com.trivedi.learning.ds.dp.tab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowSum {
    public static void main(String[] args) {
        System.out.println(howSum(new int[] {5, 3, 4}, 7));
    }

    private static List<Integer> howSum(int arr[], int target) {
        Map<Integer, List<Integer>> tab = new HashMap<>();
        tab.put(0, new ArrayList<>());

        for (int i = 0; i <= target; i++) {
            if (tab.get(i) != null) {
                for (int num : arr) {
                    if (i + num > target) continue;
                    List<Integer> list = new ArrayList<>(tab.get(i));
                    list.add(num);
                    tab.put(i + num, list);
                }
            }
        }
        return tab.get(target);
    }
}

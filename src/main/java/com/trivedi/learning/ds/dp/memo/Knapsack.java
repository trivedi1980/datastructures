package com.trivedi.learning.ds.dp.memo;

import java.util.HashMap;
import java.util.Map;

public class Knapsack {
    public static void main(String[] args) {
        Map<String, Integer> memo = new HashMap<>();
        System.out.println(maxProfit(new int[] {1, 2, 3, 5 }, new int[] {1, 6, 10, 16}, 7, 0, memo));
        memo.clear();
        System.out.println(maxProfit(new int[] {1, 2, 3, 5 }, new int[] {1, 6, 10, 16}, 6, 0, memo));
        memo.clear();
        System.out.println(maxProfit(new int[] {2, 3, 1, 4 }, new int[] {4, 5, 3, 7}, 5, 0, memo));
    }

    private static int maxProfit(int[] weights, int[] profits, int capacity, int index, Map<String, Integer> memo) {
        if (capacity <= 0) return 0;
        if (index >= weights.length) return 0;
        String key = index + ":" + capacity;
        if (memo.containsKey(key)) return memo.get(key);

        int p1 = 0;
        if (weights[index] <= capacity) {
            p1 = profits[index] + maxProfit(weights, profits, capacity - weights[index], index + 1, memo);
        }
        int p2 = maxProfit(weights, profits, capacity, index + 1, memo);
        memo.put(key, Math.max(p1, p2));
        return memo.get(key);
    }
}

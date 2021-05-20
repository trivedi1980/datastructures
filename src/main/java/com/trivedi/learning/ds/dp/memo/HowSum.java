package com.trivedi.learning.ds.dp.memo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowSum {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> memo = new HashMap<>();
        System.out.println(howSum(new int[] { 2, 3}, 7, memo));
        memo.clear();
        System.out.println(howSum(new int[] { 5, 3, 4, 7}, 7, memo));
        memo.clear();
        System.out.println(howSum(new int[] { 2, 4}, 7, memo));
        memo.clear();
        System.out.println(howSum(new int[] { 7, 14}, 600, memo));
        memo.clear();

        System.out.println(bestSum(new int[] { 2, 3, 7}, 7, memo));
        memo.clear();
        System.out.println(bestSum(new int[] { 2, 3, 5}, 8, memo));
        memo.clear();
        System.out.println(bestSum(new int[] { 1, 4, 5}, 8, memo));
        memo.clear();
    }

    private static List<Integer> howSum(int[] arr, int target, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(target)) return memo.get(target);
        if (arr.length <= 0 || target < 0) return null;
        if (target == 0) return new ArrayList<>();

        for (int value : arr) {
            if (value > target) continue;

            List<Integer> list = howSum(arr, target - value, memo);
            if (list != null) {
                list.add(value);
                memo.put(target, list);
                return list;
            }
        }
        memo.put(target, null);
        return null;
    }

    private static List<Integer> bestSum(int[] arr, int target, Map<Integer, List<Integer>> memo) {
        if (arr.length <= 0 || target < 0) return null;
        if (target == 0) return new ArrayList<>();
        if (memo.containsKey(target)) return memo.get(target);

        List<Integer> bestOne = null;
        for (int value : arr) {
            List<Integer> list = bestSum(arr, target - value, memo);
            if (list != null) {
                if (bestOne == null || bestOne.size() > list.size()) {
                    bestOne = new ArrayList<>(list);
                    bestOne.add(value);
                }
            }
        }
        // System.out.println("target: " + target + " - > " + bestOne);
        memo.put(target, bestOne);
        return bestOne;
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        return results;
    }

    private static void combinationSum(int[] candidates, int target, List<Integer> currentPath,
                                List<List<Integer>> results) {
        if (target == 0) {
            List<Integer> list = new ArrayList<>(currentPath);
            results.add(list);
            return;
        }

        if (target < 0) return;

        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] > target) continue;

            currentPath.add(candidates[i]);
            int rem = target - candidates[i];
            combinationSum(candidates, rem, currentPath, results);
            currentPath.remove(currentPath.size() - 1);
        }
    }
}

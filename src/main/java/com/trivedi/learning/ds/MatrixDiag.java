package com.trivedi.learning.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MatrixDiag {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        combinationSum(candidates, target, new ArrayList<>(), results);
        return results;
    }

    private static void combinationSum(int[] candidates, int target, List<Integer> currentPath,
                                List<List<Integer>> results) {
        if (target < 0) return;
        if (target == 0) {
            results.add(new ArrayList<>(currentPath));
            return;
        }

        int length = currentPath.size();
        boolean added = false;
        for (int i = 0; i < candidates.length; i++) {
            if (target < candidates[i]) continue;

            if (added) {
                added = false;
                currentPath.remove(length);
            }
            currentPath.add(candidates[i]);
            added = true;
            combinationSum(candidates, target - candidates[i], currentPath, results);
        }
        if (added)
            currentPath.remove(length);
    }

    public static String longestPalindrome(String s) {
        return longestPalindrome(s, 0, s.length());
    }

    private static String longestPalindrome(String s, int start, int end) {
        if (end - start <= 0) return "";
        if (end - start == 1) return s.substring(start, end);
        if (isPalindrome(s, start, end -1)) return s.substring(start, end);

        String str1 = longestPalindrome(s, start, end - 1);
        String str2 = longestPalindrome(s, start + 1, end);
        if (str1.length() > str2.length()) {
            return str1;
        } else {
            return str2;
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return uniquePathsWithObstacles(obstacleGrid.length - 1,
                obstacleGrid[0].length - 1, obstacleGrid);
    }

    public static int uniquePathsWithObstacles(int m, int n, int[][] obstacleGrid) {
        if (obstacleGrid[m][n] == 0 && m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;
        if (obstacleGrid[m][n] == 1) return 0;

        return uniquePathsWithObstacles(m - 1, n, obstacleGrid)
                + uniquePathsWithObstacles(m, n -1, obstacleGrid);
    }

    public static int uniquePaths(int m, int n) {
        Map<String, Integer> memo = new HashMap<>();
        return uniquePaths(m, n, memo);
    }

    private static int uniquePaths(int m, int n, Map<String, Integer> memo) {
        String key1 = m + ":" + n;
        //String key2 = n + ":" + m;
        if (memo.containsKey(key1)) return memo.get(key1);
        //if (memo.containsKey(key2)) return memo.get(key2);
        if (m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;

        int result = uniquePaths(m -1, n, memo) + uniquePaths(m, n -1, memo);
        memo.put(key1, result);
        //memo.put(key2, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[] {2,3,6,7}, 7));
    }
}

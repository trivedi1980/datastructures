package com.trivedi.learning.ds.dp.tab;

public class CanSum {
    public static void main(String[] args) {
        System.out.println(canSum(new int[] {5, 3, 4}, 7));
    }

    private static boolean canSum(int[] arr, int target) {
        boolean[] tab = new boolean[target + 1];
        tab[0] = true;

        for (int i = 0; i <= target; i++) {
            if (tab[i]) {
                for (int j = 0; j < arr.length; j++) {
                    if (i + arr[j] > target) continue;
                    tab[i + arr[j]] = true;
                }
            }
        }
        return tab[target];
    }
}

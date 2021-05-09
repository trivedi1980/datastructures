package com.trivedi.learning.ds;

class Knapsack {

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        int[][] m = new int[profits.length][capacity  +1];

        // max profits are zero for capacity 0
        for (int i = 0; i < profits.length; i++) {
            m[i][0] = 0;
        }

        // populate profits for first row
        for (int c = 1; c <= capacity; c++) {
            if (weights[0] <= capacity) {
                m[0][c] = profits[0];
            } else {
                m[0][c] = 0;
            }
        }

        for (int i = 1; i < profits.length; i++) {
            for (int c = 1; c <=capacity; c++) {
                if (c - weights[i] >= 0)
                    m[i][c] = Math.max(profits[i] + m[i-1][c - weights[i]], m[i-1][c]);
                else
                    m[i][c] = m[i - 1][c];
            }
        }
        printSelectedElements(m, weights, profits, capacity);
        return m[profits.length - 1][capacity];
    }

    private void printSelectedElements(int[][] dp, int[] weights, int[] profits, int capacity){
        int totalProfit = dp[weights.length - 1][capacity];
        int i = weights.length -1;
        int c = capacity;
        while (i > 0) {
            if (dp[i -1][c] != totalProfit) {
                System.out.print(" " + weights[i]);
                c = c - weights[i];
                totalProfit = totalProfit - profits[i];
            }
            i--;
        }
        if (totalProfit != 0) {
            System.out.print(" " + weights[0]);
        }
    }

    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}

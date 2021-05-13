package com.trivedi.learning.ds.bst;

public class CapacityOfShip {
    public static int shipWithinDays(int[] weights, int D) {
        int sum = sum(weights);
        int start = max(weights);
        int end = sum;
        int response = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int days = findDaysWithMaxWeight(weights, mid);

            if (days > D) {
                start = mid + 1;
            } else {
                response = mid;
                end = mid - 1;
            }
        }
        return response;
    }

    private static int max(int[] weights) {
        int max = 0;
        for (int w : weights) {
            max = Math.max(max, w);
        }
        return max;
    }

    private static int findDaysWithMaxWeight(int[] weights, int max) {
        int days = 1;
        int weight = 0;
        for (int w : weights) {
            weight += w;
            if (weight > max) {
                days++;
                weight = w;
            }
        }
        return days;
    }

    private static int sum(int[] weights) {
        int sum = 0;
        for (int w : weights) {
            sum += w;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[] {1, 2, 3, 1, 1}, 4));
    }
}

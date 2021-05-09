package com.trivedi.learning.ds.slidingwindow;

public class FindAvgOfAllContiguousArray {
    public static double[] findAvgOfAllContiguousArray(int[] a, int k) {
        int ws = 0;
        int we = k - 1;
        double[] res = new double[a.length - k + 1];
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += a[i];
        }

        int i = 0;
        while (we < a.length) {
            res[i++] = sum * 1.0 / k;
            sum -= a[ws++];
            we++;
            if (we < a.length)
                sum += a[we];
        }

        return res;
    }

    public static void main(String[] args) {
        double[] res = findAvgOfAllContiguousArray(new int[] {1, 3, 2, 6, -1, 4, 1, 8, 2}, 5);
        for( double each : res) {
            System.out.println(each);
        }
    }
}

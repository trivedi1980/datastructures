package com.trivedi.learning.ds.bst;

public class XPowerNumber {
    public static void main(String[] args) {
        System.out.println(xPow(2.00000, 10));
    }

    private static double xPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;

        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        return n % 2 == 0 ? xPow(x, n / 2) * xPow(x, n / 2)
                : xPow(x, n / 2) * xPow(x, (n / 2) + 1);
    }
}

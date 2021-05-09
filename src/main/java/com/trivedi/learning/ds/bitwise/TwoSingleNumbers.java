package com.trivedi.learning.ds.bitwise;

class TwoSingleNumbers {

    public static int[] findSingleNumbers(int[] nums) {
        int n1xn2 = 0;
        for (int num : nums) {
            n1xn2 = num ^ n1xn2;
        }
        int setBit = 1;
        while ((setBit & n1xn2) == 0) {
            setBit = setBit << 1;
        }

        int n1 = 0;
        int n2 = 0;
        for (int num : nums) {
            if ((num & setBit) > 0) {
                n1 = num ^ n1;
            } else {
                n2 = num ^ n2;
            }
        }
        return new int[] { n1, n2 };
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 4, 2, 1, 3, 5, 6, 2, 3, 5 };
        int[] result = TwoSingleNumbers.findSingleNumbers(arr);
        System.out.println("Single numbers are: " + result[0] + ", " + result[1]);

        arr = new int[] { 2, 1, 3, 2 };
        result = TwoSingleNumbers.findSingleNumbers(arr);
        System.out.println("Single numbers are: " + result[0] + ", " + result[1]);
    }
}

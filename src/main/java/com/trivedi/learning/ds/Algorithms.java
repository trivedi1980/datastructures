package com.trivedi.learning.ds;

public class Algorithms {
    public static int reverse(int num) {
        int result = 0;
        while (num > 0 ) {
            int q = num % 10;
            result = result * 10 + q;
            num = num / 10;
        }
        return result;
    }

    public static boolean palindrome(int num) {
        if (num < 0) {
            return false;
        }
        int noOfDigits = 0;
        int temp = num;
        while (temp != 0) {
            temp = temp / 10;
            noOfDigits++;
        }
        temp = (int) Math.pow(10, noOfDigits - 1);

        for (int i = 0; i < (noOfDigits / 2); i++) {
            if (num / temp != num % 10) {
                return false;
            }
            num = num % temp;
            num = num / 10;
            temp = temp/100;
        }
        return true;
    }

    public static int random(int start, int end) {
        return (int) (Math.random() * (end - start) + start);
    }
}

package com.trivedi.learning.ds;

public class Test {
    private static int getTabooNumCount(int num, int tabooNum) {
        int count = 0;
        int origTabooNum = tabooNum;
        while (num > 0) {
            int tDigit = tabooNum % 10;
            int nDigit = num % 10;

            tabooNum = tabooNum / 10;

            if (tabooNum == 0) {
                count++;
                tabooNum = origTabooNum;
            }

            num = num / 10;
        }
        return count;
    }
    public static void main (String[] args) {
        System.out.println(getTabooNumCount(13322, 33));
    }
}

package com.trivedi.learning.ds.bitwise;

public class BitwiseAlgorithms {
    public static short countSetBits(int num) {
        short count = 0;
        while (num != 0) {
            count = (short) (count + (num & 1));
            num = num >>> 1;
        }
        return count;
    }

    public static short countSetBits2(int num) {
        short count = 0;
        while(num != 0) {
            count++;
            num = num & (num -1);
        }
        return count;
    }

    public static short parity(int num) {
        short parity = 0;
        while (num != 0) {
            parity ^= 1;
            num = num & (num -1);
        }
        return parity;
    }

    public static int rightPropagateRightMostSetBit(int num) {
        return num | (num - 1);
    }

    public static boolean isPowerOfTwo(int num) {
        if (num <= 0) return false;

        return (num & (num - 1)) == 0;
    }

    public static int xModPowerTwo(int num, int deno) {
        return num & (deno - 1);
    }

    public static int swapBits(int num, int i, int j) {
        if (((num >>> i) & 1) != ((num >>> j) & 1)) {
            return (num ^ (1 << i | 1 << j));
        }
        return num;
    }

    public static int reverseBits(int num, short bitCount) {
        int start = 0, end = bitCount - 1;
        while (start < end) {
            num = swapBits(num, start, end);
            start++;
            end--;
        }
        return num;
    }

    public static int closestIntSameWeight(int input) {
        if ((input & 1) == 0) {
            // LSB is 0
            int firstOne = (input & ~(input - 1));
            input = input ^ firstOne;
            input = input | (firstOne >>> 1);
        } else {
            // LSB is 1
            int firstZero = (~input & ~(~input -1));
            input = input & ~1;
            input = input | firstZero;
        }
        return input;
    }
}

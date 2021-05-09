package com.trivedi.learning.ds.bitwise;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BitwiseAlgorithmsTest {
    @Test
    public void testCountSetBits() {
        Assertions.assertEquals(3, BitwiseAlgorithms.countSetBits(25));
        Assertions.assertEquals(1, BitwiseAlgorithms.countSetBits(8));
        Assertions.assertEquals(0, BitwiseAlgorithms.countSetBits(0));
        Assertions.assertEquals(3, BitwiseAlgorithms.countSetBits(13));
    }

    @Test
    public void testCountSetBits2() {
        Assertions.assertEquals(3, BitwiseAlgorithms.countSetBits2(25));
        Assertions.assertEquals(1, BitwiseAlgorithms.countSetBits2(8));
        Assertions.assertEquals(0, BitwiseAlgorithms.countSetBits2(0));
        Assertions.assertEquals(3, BitwiseAlgorithms.countSetBits2(13));
    }

    @Test
    public void testParity() {
        Assertions.assertEquals(1, BitwiseAlgorithms.parity(13));
        Assertions.assertEquals(1, BitwiseAlgorithms.parity(8));
        Assertions.assertEquals(0, BitwiseAlgorithms.parity(3));
    }

    @Test
    public void testRightPropagateRightMostSetBit() {
        Assertions.assertEquals(3, BitwiseAlgorithms.rightPropagateRightMostSetBit(2));
        Assertions.assertEquals(7, BitwiseAlgorithms.rightPropagateRightMostSetBit(4));
        Assertions.assertEquals(95, BitwiseAlgorithms.rightPropagateRightMostSetBit(80));
    }

    @Test
    public void testIsPowerOfTwo() {
        Assertions.assertTrue(BitwiseAlgorithms.isPowerOfTwo(2));
        Assertions.assertTrue(BitwiseAlgorithms.isPowerOfTwo(4));
        Assertions.assertTrue(BitwiseAlgorithms.isPowerOfTwo(8));
        Assertions.assertTrue(BitwiseAlgorithms.isPowerOfTwo(256));
        Assertions.assertFalse(BitwiseAlgorithms.isPowerOfTwo(12));
        Assertions.assertTrue(BitwiseAlgorithms.isPowerOfTwo(1));
        Assertions.assertFalse(BitwiseAlgorithms.isPowerOfTwo(3));
        Assertions.assertFalse(BitwiseAlgorithms.isPowerOfTwo(0));
    }

    @Test
    public void testXModPowerTwo() {
        Assertions.assertEquals(13, BitwiseAlgorithms.xModPowerTwo(77, 64));
    }

    @Test
    public void testSwapBits() {
        Assertions.assertEquals(11, BitwiseAlgorithms.swapBits(73, 1, 6));
    }

    @Test
    public void testReverseBits() {
        Assertions.assertEquals(12, BitwiseAlgorithms.reverseBits(3, (short)4));
    }

    @Test
    public void testClosestIntSameWeight() {
        Assertions.assertEquals(90, BitwiseAlgorithms.closestIntSameWeight(92));
        Assertions.assertEquals(18, BitwiseAlgorithms.closestIntSameWeight(17));
    }
}

package com.trivedi.learning.ds;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SlidingWindowTest {
    @Test
    public void testAvgOfAllContiguousSubArrays() {
        int[] array = new int[] {1, 3, 2, 6, -1, 4, 1, 8, 2};
        List<Float> floatList = SlidingWindow.avgOfAllContiguousSubArrays(array, 5);
        System.out.println(floatList);
    }

    @Test
    public void testAvgOfAllContiguousSubArraysWithSlidingWindow() {
        int[] array = new int[] {1, 3, 2, 6, -1, 4, 1, 8, 2};
        float[] avgs = SlidingWindow.avgOfAllContiguousSubArrays2(array, 5);
        for (float f :
                avgs) {
            System.out.print(f + ", ");
        }
    }

    @Test
    public void testMaxSumOfAnyContiguousSubArray() {
        int[] a = new int[] {2, 1, 5, 1, 3, 2};
        int max = SlidingWindow.maxSumOfAnyContiguousSubArray(a, 3);
        Assert.assertEquals(9, max);
        a = new int[] {2, 3, 4, 1, 5};
        max = SlidingWindow.maxSumOfAnyContiguousSubArray(a, 2);
        Assert.assertEquals(7, max);
    }

    @Test
    public void testSmallestSubArrayWithGivenSum() {
        int[] a = new int[] { 1, 1, 7};
        int size = SlidingWindow.smallestSubArrayWithGivenSum(a, 7);
        Assert.assertEquals(1, size);
        Assert.assertEquals(2, SlidingWindow.smallestSubArrayWithGivenSum(
                new int[] { 2, 1, 5, 2, 3, 2 }, 7));
    }

    @Test
    public void testLongestSubStringWithKUniqueChars() {
        int length = SlidingWindow.longestSubStringWithKUniqueChars2("araaci", 1);
        Assert.assertEquals(2, length);
    }

    @Test
    public void testLongestSubStringNoRepeat() {
        int length = SlidingWindow.longestSubStringNoRepeat("aabccbb");
        Assert.assertEquals(3, length);
    }
}

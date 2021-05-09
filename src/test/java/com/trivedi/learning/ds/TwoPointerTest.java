package com.trivedi.learning.ds;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TwoPointerTest {
    @Test
    public void testRemoveDuplicates() {
        int a[] = new int[] {2, 3, 3, 3, 6, 9, 9};
        int len = TwoPointer.removeDuplicates(a);
        Assert.assertEquals(4, len);
    }

    @Test
    public void testSortedSquares() {
        int[] sortedSquares = TwoPointer.sortedSquares(new int[] {-2, -1, 0, 2, 3});
        for (int item :
                sortedSquares) {
            System.out.print(item + ", ");
        }
    }

    @Test
    public void testTriplet() {
        List<List<Integer>> triplets = TwoPointer.tripletSumZero(new int[] { -3, 0, 1, 2, -1, 1, -2 });
        System.out.println(triplets);
    }

    @Test
    public void testFindTriplet() {
        boolean found = TwoPointer.findTripletSum(new int[] { 12, 3, 4, 1, 6, 9}, 24);
        Assert.assertTrue(found);
    }
}

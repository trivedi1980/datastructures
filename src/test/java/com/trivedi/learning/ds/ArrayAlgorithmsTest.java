package com.trivedi.learning.ds;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ArrayAlgorithmsTest {
    @Test
    public void testIntersection() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(3);
        list1.add(5);
        list1.add(6);
        list1.add(2);

        list2.add(4);
        list2.add(6);
        list2.add(7);
        list2.add(3);
        list2.add(1);

        List<Integer> results = ArrayAlgorithms.getIntersection(list1, list2);
        Assert.assertEquals(2, results.size());
        Assert.assertTrue(results.contains(6));
        Assert.assertFalse(results.contains(1));
    }

    @Test
    public void testIntersection2() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(3);
        list1.add(5);
        list1.add(6);
        list1.add(2);


        list2.add(6);

        List<Integer> results = ArrayAlgorithms.getIntersection(list1, list2);
        Assert.assertEquals(1, results.size());
        Assert.assertTrue(results.contains(6));
        Assert.assertFalse(results.contains(1));
    }

    @Test
    public void testOrder() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(5);
        list1.add(6);
        list1.add(2);
        ArrayAlgorithms.orderEvenAndOdd(list1);

        Assert.assertEquals(new Integer(2), list1.get(0));
        Assert.assertEquals(new Integer(6), list1.get(1));
    }

    @Test
    public void testSelectionSort() {
        int[] list = new int[] {64, 25, 12, 22, 11};
        list = ArrayAlgorithms.selectionSort(list);
        Assert.assertEquals(11, list[0]);
        Assert.assertEquals(12, list[1]);
        Assert.assertEquals(22, list[2]);
        Assert.assertEquals(25, list[3]);
        Assert.assertEquals(64, list[4]);
    }

    @Test
    public void testDutchPartition() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(1);
        list.add(2);

        ArrayAlgorithms.dutchFlag(list, 2);
        Assert.assertEquals(1, list.get(0).intValue());
        Assert.assertEquals(1, list.get(1).intValue());
    }
}

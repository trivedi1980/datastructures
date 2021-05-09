package com.trivedi.learning.ds.trees;

import org.junit.Assert;
import org.junit.Test;

public class BasicBinaryTreeTest {
    @Test
    public void testBinaryTreeCreation() {
        BasicBinaryTree<Integer> bbt = new BasicBinaryTree<>();
        Assert.assertEquals(0, bbt.size());

        bbt.add(12);
        Assert.assertEquals(1, bbt.size());

        bbt.add(5);
        Assert.assertEquals(2, bbt.size());

        Assert.assertTrue(bbt.contains(12));
        Assert.assertFalse(bbt.contains(22));
        bbt.add(15);
        bbt.add(3);
        bbt.add(7);
        bbt.add(1);
        bbt.add(9);
        bbt.add(13);
        bbt.add(17);
        bbt.print();

        bbt.delete(5);
        bbt.print();
    }
}

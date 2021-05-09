package com.trivedi.learning.ds;

import org.junit.Assert;
import org.junit.Test;

public class AlgorithmsTest {
    @Test
    public void testReverse() {
        Assert.assertEquals(42, Algorithms.reverse(24));
        Assert.assertEquals(0, Algorithms.reverse(0));
    }

    @Test
    public void testPalindrome() {
        Assert.assertTrue(Algorithms.palindrome(212));
        Assert.assertTrue(Algorithms.palindrome(2112));
        Assert.assertFalse(Algorithms.palindrome(21));
        Assert.assertTrue(Algorithms.palindrome(1));
    }

    @Test
    public void testRandom() {
        int random = Algorithms.random(5, 10);
        System.out.println(random);
        Assert.assertTrue(random >= 5 && random <= 10);
    }
}

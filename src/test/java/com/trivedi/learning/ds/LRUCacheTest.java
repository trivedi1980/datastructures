package com.trivedi.learning.ds;

import org.junit.Assert;
import org.junit.Test;

public class LRUCacheTest {
    @Test
    public void testLRUCache() {
        LRUCache lruCache = new LRUCache(10);
        Assert.assertEquals(10, lruCache.availableSize());

        Assert.assertFalse(lruCache.add("1", "12345678900"));
        Assert.assertEquals(10, lruCache.availableSize());
        Assert.assertNull(lruCache.get("1"));

        Assert.assertTrue(lruCache.add("1", "1"));
        Assert.assertTrue(lruCache.add("2", "2"));
        Assert.assertTrue(lruCache.add("3", "3"));
        Assert.assertFalse(lruCache.add("2", "2"));
        Assert.assertEquals(7, lruCache.availableSize());
        lruCache.display();
        lruCache.get("1");
        Assert.assertEquals("1", lruCache.recent());
        lruCache.display();

        lruCache.add("3", "45678");
        lruCache.add("4", "45679");
        lruCache.display();
        lruCache.add("1", "1");
        lruCache.display();
        lruCache.add("2", "1234567890");
        lruCache.get("2");
        lruCache.display();
    }
}

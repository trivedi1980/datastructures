package com.trivedi.learning.ds;

import org.junit.Assert;
import org.junit.Test;

public class QueueTest {
    @Test
    public void testQueue() {
        Queue queue = new Queue();
        Assert.assertEquals(0, queue.size());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        Assert.assertEquals(3, queue.size());
        Assert.assertEquals(1, queue.dequeue());
        Assert.assertEquals(2, queue.dequeue());
        Assert.assertEquals(3, queue.dequeue());
        Assert.assertEquals(0, queue.size());
    }
}

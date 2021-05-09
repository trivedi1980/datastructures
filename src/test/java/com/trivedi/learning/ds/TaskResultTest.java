package com.trivedi.learning.ds;

import org.junit.Assert;
import org.junit.Test;

public class TaskResultTest {
    @Test
    public void testEmptyTaskResult() {
        Assert.assertEquals(0, TaskResult.taskResult(null, null));
        String[] t = new String[] {"task1", "task2a", "task2b", "task3"};
        String[]  r = new String[] {"OK", "Wrong Answer", "OK", "OK"};
        Assert.assertEquals(66, TaskResult.taskResult(t, r));
    }
}

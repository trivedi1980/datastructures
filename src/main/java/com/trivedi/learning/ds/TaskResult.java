package com.trivedi.learning.ds;

import java.util.HashSet;
import java.util.Set;

public class TaskResult {
    public static int taskResult(String[] tasks, String[] results) {
        int result = 0;
        Set<Integer> uniqueTasks = new HashSet<>();
        Set<Integer> failedTasks = new HashSet<>();
        if (tasks != null && results != null && tasks.length > 0 & results.length > 0
                && tasks.length == results.length) {
            for (int i = 0; i < tasks.length; i++) {
                int taskId = getTaskId(tasks[i]);
                if (taskId == -1) continue;

                uniqueTasks.add(taskId);
                if (!results[i].equals("OK")) {
                    failedTasks.add(taskId);
                }
            }
            result = ((uniqueTasks.size() - failedTasks.size()) * 100) / uniqueTasks.size();
        }
        return result;
    }

    private static int getTaskId(String taskName) {
        int taskId = 0;
        boolean oneDigitFound = false;
        for (int i = 4; i < taskName.length(); i++) {
            if (!Character.isDigit(taskName.charAt(i))) {
                return oneDigitFound ? taskId : -1;
            }
            oneDigitFound = true;
            taskId = taskId * 10 + Character.getNumericValue(taskName.charAt(i));
        }
        return taskId;
    }
}

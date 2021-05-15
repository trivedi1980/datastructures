package com.trivedi.learning.ds.mi;

import java.util.*;

public class MaximumCPULoad {
    private static class Job {
        int start;
        int end;
        int cpuLoad;

        public Job(int start, int end, int cpuLoad) {
            this.start = start;
            this.end = end;
            this.cpuLoad = cpuLoad;
        }
    };

    public static int findMaxCPULoad(List<Job> jobs) {
        Collections.sort(jobs, (j1, j2) -> j1.start - j2.start);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int max = jobs.get(0).cpuLoad;
        minHeap.offer(jobs.get(0).end);
        for (int i = 1; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (curr.start < minHeap.peek()) {
                max += curr.cpuLoad;
            } else {
                max = Math.max(max, curr.cpuLoad);
                minHeap.poll();
            }
            minHeap.offer(curr.end);
        }
        return max;
    }

    public static void main(String[] args) {
        List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3),
                new Job(2, 5, 4), new Job(7, 9, 6)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10),
                new Job(2, 4, 11), new Job(8, 12, 15)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2),
                new Job(2, 4, 1), new Job(3, 6, 5)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));
    }
}

package com.trivedi.learning.ds.mi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    private static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    };

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<List<Integer>> results = new ArrayList<>();

        int[] curr = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (curr[1] >= intervals[i][0]) {
                curr[0] = Math.min(curr[0], intervals[i][0]);
                curr[1] = Math.max(curr[1], intervals[i][1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(curr[0]);
                list.add(curr[1]);
                results.add(list);
                curr = intervals[i];
            }
        }

        List<Integer> list = new ArrayList<>();
        list.add(curr[0]);
        list.add(curr[1]);
        results.add(list);

        int[][] response = new int[results.size()][2];
        int i = 0;
        for (List<Integer> each: results) {
            response[i] = new int[2];
            response[i][0] = each.get(0);
            response[i][1] = each.get(1);
            i++;
        }
        return response;
    }

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0) return intervals;
        intervals.sort(Comparator.comparingInt(i -> i.start));

        List<Interval> merge = new ArrayList<>();
        Interval curr = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            if (curr.end < intervals.get(i).start) {
                merge.add(curr);
                curr = intervals.get(i);
            } else {
                curr = new Interval(Math.min(curr.start, intervals.get(i).start),
                        Math.max(curr.end, intervals.get(i).end));
            }
        }
        merge.add(curr);
        return merge;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        int[][] data = new int[][] { {1,3},{2,6},{8,10},{15,18}};
        int[][] response = merge(data);
        for (int[] each : response) {
            System.out.println(Arrays.toString(each));
        }
    }
}

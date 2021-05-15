package com.trivedi.learning.ds.mi;

import java.util.ArrayList;
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
    }
}

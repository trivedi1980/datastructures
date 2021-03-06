package com.trivedi.learning.ds.mi;

import java.util.ArrayList;
import java.util.List;

public class IntervalsIntersection {
    private static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    };

    private static Interval[] merge(Interval[] arr1, Interval[] arr2) {
        int i = 0;
        int j = 0;
        List<Interval> list = new ArrayList<>();
        while (i < arr1.length && j < arr2.length) {
            Interval one = arr1[i];
            Interval two = arr2[j];
            if ((one.start <= two.start && one.end >= two.start)
                    || (two.start <= one.start && two.end >= one.start)) {
                list.add(new Interval(Math.max(one.start, two.start), Math.min(one.end, two.end)));
            }

            if (arr1[i].end < arr2[j].end) {
                i++;
            } else {
                j++;
            }
        }
        return list.toArray(new Interval[0]);
    }

    public static void main(String[] args) {
        Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
        Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
        Interval[] result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
        input2 = new Interval[] { new Interval(5, 10) };
        result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
    }
}

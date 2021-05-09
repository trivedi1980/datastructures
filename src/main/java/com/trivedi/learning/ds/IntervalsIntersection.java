package com.trivedi.learning.ds;

import java.util.*;

class IntervalsIntersection {

    public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
        List<Interval> intervalsIntersection = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            Interval one = arr1[i];
            Interval two = arr2[j];

            if ((one.start <= two.start && one.end >= two.start)
                    || (two.start <= one.start && two.end >= one.start)) {
                intervalsIntersection.add(new Interval(Math.max(one.start, two.start), Math.min(one.end, two.end)));
            }

            if (one.end > two.end) {
                j++;
            } else {
                i++;
            }
        }
        return intervalsIntersection.toArray(new Interval[0]);
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


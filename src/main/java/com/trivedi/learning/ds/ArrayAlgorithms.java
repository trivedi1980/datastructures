package com.trivedi.learning.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayAlgorithms {
    public static List<Integer> getIntersection(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>();

        Collections.sort(list1);
        Collections.sort(list2);

        int i = list1.size() - 1;
        int j = list2.size() - 1;

        while (i >=0 && j >=0) {
            int comp = list1.get(i).compareTo(list2.get(j));
            if (comp == 0) {
                result.add(list1.get(i));
                i--;
                j--;
            } else if (comp < 0) {
                j--;
            } else {
                i--;
            }
        }

        return result;
    }

    public static void orderEvenAndOdd(List<Integer> list) {
        int evenIndex = 0;
        int oddIndex = list.size() - 1;

        while (evenIndex < oddIndex) {
            if (list.get(evenIndex) % 2 == 0) {
                evenIndex++;
            } else {
                Collections.swap(list, evenIndex, oddIndex--);
            }
        }
    }

    public static int trap(int[] height) {
        int count = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        // set left max
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax [i] = Math.max(height[i], leftMax[i -1]);
        }

        // set right max
        rightMax[height.length -1] = height[height.length -1];
        for (int i = height.length - 2; i >=0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        for (int i = 0; i < height.length; i++) {
            int lMax = leftMax[i];
            int rMax = rightMax[i];
            if (height[i] != lMax && height[i] != rMax) {
                count = count + Math.min(lMax, rMax) - height[i];
            }
        }
        return count;
    }

    public static int[] selectionSort(int[] list) {
        int max;
        for (int i = 0; i < list.length; i++) {
            max = 0;
            for (int j = 1; j < list.length - i; j++) {
                if (list[max] < list[j]) {
                    max = j;
                }
            }
            int temp = list[max];
            list[max] = list[list.length - 1 - i];
            list[list.length - 1 - i] = temp;
        }
        return list;
    }

    public static void dutchFlag(List<Integer> list, Integer pivot) {
        int smaller = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).compareTo(pivot) < 0) {
                Collections.swap(list, i, smaller++);
            }
        }

        int larger = list.size() - 1;
        for (int i = larger; i >= 0; i--) {
            if (list.get(i).compareTo(pivot) > 0) {
                Collections.swap(list, i, larger--);
            }
        }
    }
}

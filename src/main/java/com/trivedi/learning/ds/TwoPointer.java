package com.trivedi.learning.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointer {
    public static int[] pairWithTarget(int[] a, int sum) {
        int i = 0;
        int j = a.length - 1;
        int[] pair = new int[2];
        while (i <= j) {
            int compSum = a[i] + a[j];
            if (compSum == sum) {
                pair[0] = a[i];
                pair[1] = a[j];
                break;
            } else if (compSum > sum) {
                j--;
            } else {
                i++;
            }
        }
        return pair;
    }

    public static int removeDuplicates(int[] a) {
        int nonDuplicateIndex = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[i-1]) {
                nonDuplicateIndex++;
                a[nonDuplicateIndex] = a[i];
            }
        }
        return nonDuplicateIndex+1;
    }

    public static int[] sortedSquares(int[] a) {
        int i = 0;
        int j = a.length - 1;
        int[] squares = new int[a.length];
        int index = j;
        while (i < j) {
            if (Math.abs(a[i]) > Math.abs(a[j])) {
                squares[index] = a[i] * a[i];
                i++;
            } else {
                squares[index] = a[j] * a[j];
                j--;
            }
            index--;
        }
        return squares;
    }

    public static List<List<Integer>> tripletSumZero(int[] a) {
        Arrays.sort(a);
        List<List<Integer>> tripletList = new ArrayList<>();
        for (int i = 0; i < a.length - 2; i++) {
            if (i > 0 && a[i] == a[i - 1]) continue;

            int j = i + 1;
            int k = a.length - 1;

            while (j < k) {
                int value = a[i] + a[j] + a[k];
                if (value == 0) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(a[i]);
                    triplet.add(a[j]);
                    triplet.add(a[k]);
                    tripletList.add(triplet);
                    j++;
                    k--;
                    while(j < k && a[j] == a[j-1]) j++;
                    while(j < k && a[k] == a[k+1]) k--;
                } else if (value > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return tripletList;
    }

    public static int tripletSumClosestToTarget(int[] a, int target) {
        Arrays.sort(a);

        int oldDiff = Integer.MAX_VALUE;

        for (int i = 0; i < a.length - 2; i++) {
            int left = i + 1;
            int right = a.length -1;
            while(left < right) {
                int newDiff = target - (a[i] + a[left] + a[right]);
                if (oldDiff > newDiff) {
                    oldDiff = newDiff;
                }
                if (newDiff > 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return oldDiff;
    }

    public static List<List<Integer>> subArraysWithProductLessThanTarget(int[] a, int target) {
        List<List<Integer>> subArrays = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] > target) continue;;
            subArrays.add(Arrays.asList(a[i]));
            int prod = a[i];
            for (int j = i + 1; j < a.length; j++) {
                prod = prod * a[j];
                if (prod < target) {
                    List<Integer> list = new ArrayList<>();
                    for (int k = i; k <=j; k++) {
                        list.add(a[k]);
                    }
                    subArrays.add(list);
                } else {
                    break;
                }
            }
        }
        return subArrays;
    }

    public static boolean findTripletSum(int[] a, int sum) {
        Arrays.sort(a);
        boolean found = false;
        for (int i = 0; i < a.length - 2; i++) {
            int j = i + 1;
            int k = a.length - 1;
            int diff = sum - a[i];
            while(j < k) {
                int comp = a[j] + a[k] - diff;
                if (comp == 0) {
                    found = true;
                    break;
                } else if (comp < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return found;
    }

    public static boolean isHappyNumber(int num) {
        int slow = num;
        int fast = num;

        while (slow != 1 && fast != 1) {
            slow = sumOfSquares(slow);
            fast = sumOfSquares(fast);
            fast = sumOfSquares(fast);

            if (slow == fast) {
                return false;
            }
        }
        return true;
    }

    public static int sumOfSquares(int num) {
        int value = 0;
        while (num != 0) {
            value = value + (num % 10) * (num % 10);
            num = num / 10;
        }
        return value;
    }
}

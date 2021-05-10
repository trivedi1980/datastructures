package com.trivedi.learning.ds.twopointers;

public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] {2, 3, 3, 3, 6, 9, 9}));
    }

    private static int removeDuplicates(int[] arr) {
        int uniqueIndex = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i -1]) {
                continue;
            }

            arr[uniqueIndex] = arr[i];
            uniqueIndex++;
        }
        return uniqueIndex;
    }
}

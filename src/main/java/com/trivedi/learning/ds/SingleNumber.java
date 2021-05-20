package com.trivedi.learning.ds;

import java.util.Arrays;

public class SingleNumber {
    public static int findSingleNumber(int[] arr) {
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid % 2 == 0 && arr[mid] == arr[mid+1]) { // do we need to check index out of boundary condition??
                start = mid + 2;
            } else if (mid % 2 == 0 && arr[mid] == arr[mid - 1]) {
                end = mid;
            } else if (mid % 2 == 1 && arr[mid] == arr[mid -1]) {
                start = mid + 1;
            } else if (mid % 2 == 1 && arr[mid] == arr[mid + 1]) {
                end = mid - 1;
            } else {
                return arr[mid];
            }
        }
        return arr[start];
    }

    public static void main( String args[] ) {
        //System.out.println(findSingleNumber(new int[]{1, 4, 2, 1, 3, 2, 3}));
        //System.out.println(findSingleNumber(new int[]{7, 9, 7}));
        System.out.println(findSingleNumber(new int[] {-336,513,-560,-481,-174,101,-997,40,-527,-784,
                -283,-336,513,-560,-481,-174,101,-997,40,-527,-784,-283,354}));
    }
}

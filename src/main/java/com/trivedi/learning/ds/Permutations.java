package com.trivedi.learning.ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Permutations {

    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        java.util.Queue<List<Integer>> perm = new LinkedList<>();
        perm.add(new ArrayList<>());
        for (int num : nums) {
            int length = perm.size();
            for (int j = 0; j < length; j++) {
                List<Integer> oldPerm = perm.poll();
                for (int index = 0; index <= oldPerm.size(); index++) {
                    List<Integer> list = new ArrayList<>(oldPerm);
                    list.add(index, num);
                    if (list.size() == nums.length)
                        result.add(list);
                    else
                        perm.add(list);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }
}

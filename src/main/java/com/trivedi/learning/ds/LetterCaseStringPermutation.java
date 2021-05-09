package com.trivedi.learning.ds;

import java.util.*;

class LetterCaseStringPermutation {

    public static List<String> findLetterCaseStringPermutations(String str) {
        java.util.Queue<String> perm = new LinkedList<>();
        perm.add(str);
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isAlphabetic(ch)) {
                int length = perm.size();
                for (int j = 0; j < length; j++) {
                    String value = perm.poll();
                    perm.add(value.replace(ch, changeLetterCase(ch)));
                    perm.add(value);
                }
            }
        }
        return new ArrayList<>(perm);
    }

    private static char changeLetterCase(char c) {
        return Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);
    }

    public static void main(String[] args) {
        List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }
}


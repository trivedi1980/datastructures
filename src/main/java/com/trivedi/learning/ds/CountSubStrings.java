package com.trivedi.learning.ds;

public class CountSubStrings {
    public static int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            count++;
            String str = "" + chars[i];
            for (int j = i + 1; j < chars.length; j++) {
                str += chars[j];
                if (isPalindrome(str)) count++;
            }
        }
        return count;
    }

    private static boolean isPalindrome(String str) {
        int s = 0;
        int e = str.length() - 1;
        while (s <= e) {
            if (str.charAt(s) != str.charAt(e)) return false;
            s++;
            e--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }
}

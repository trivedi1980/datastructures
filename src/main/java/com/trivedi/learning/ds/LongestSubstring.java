package com.trivedi.learning.ds;

class LongestSubstring {
    public static String longestPalindrome(String s) {
        if (s.length() == 1) return s;

        int length = 0;
        String subStr = null;
        //Boolean[][] result = new Boolean[s.length()][s.length()];

        for (int i=0 ; i < s.length(); i++) {
            for (int j=1; j < s.length(); j++) {
                //result[i][j] = result[i][j] == null ? isPalindrome(s, i, j) : result[i][j];
                if (isPalindrome(s, i, j)) {
                    int temp = length;
                    length = Math.max(length, (j - i + 1));
                    if (length != temp) {
                        subStr = s.substring(i, j+1);
                    }
                }
            }
        }
        return subStr;
    }

    private static boolean isPalindrome(String str, int s, int e) {
        while (s <= e) {
            if (str.charAt(s++) != str.charAt(e--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aacabdkacaa"));
    }
}



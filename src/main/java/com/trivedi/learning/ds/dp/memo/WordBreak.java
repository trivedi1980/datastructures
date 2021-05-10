package com.trivedi.learning.ds.dp.memo;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        Map<String, Boolean> memo = new HashMap<>();
        Map<String, Integer> memo2 = new HashMap<>();

        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        wordDict.add("le");
        wordDict.add("et");
        System.out.println(wordBreak("leetcode", wordDict, memo));
        System.out.println(countWordBreak("leetcode", wordDict, memo2));

        wordDict.clear();
        memo.clear();
        memo2.clear();
        wordDict.add("car");
        wordDict.add("ca");
        wordDict.add("rs");
        System.out.println(wordBreak("cars", wordDict, memo));
        System.out.println(countWordBreak("cars", wordDict, memo2));

        String[] words = new String[] {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa",
                "aaaaaaaaa","aaaaaaaaaa"};
        wordDict.clear();
        memo.clear();
        memo2.clear();
        wordDict.addAll(Arrays.asList(words));
        System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                        "aaaaaaaaaaaaab",
                wordDict, memo));
        System.out.println(countWordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                        "aaaaaaaaaaaaab",
                wordDict, memo2));

    }

    private static boolean wordBreak(String s, List<String> wordDict, Map<String, Boolean> memo) {
        if (s == null || s.isEmpty()) return true;
        if (memo.containsKey(s)) return memo.get(s);
        for (String word : wordDict) {
            int index = s.indexOf(word);
            if (index == 0 && wordBreak(s.substring(word.length()), wordDict, memo)) {
                memo.put(s, true);
                return true;
            }
        }
        memo.put(s, false);
        return false;
    }

    private static int countWordBreak(String s, List<String> wordDict, Map<String, Integer> memo) {
        if (s == null || s.isEmpty()) return 1;
        if (memo.containsKey(s)) return memo.get(s);
        int count = 0;
        for (String word : wordDict) {
            int index = s.indexOf(word);
            if (index == 0) {
                count += countWordBreak(s.substring(word.length()), wordDict, memo);
            }
        }
        memo.put(s, count);
        return count;
    }
}

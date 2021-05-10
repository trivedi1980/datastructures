package com.trivedi.learning.ds.dp.memo;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        Map<String, Boolean> memo = new HashMap<>();

        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak("leetcode", wordDict, memo));

        wordDict.clear();;
        wordDict.add("car");
        wordDict.add("ca");
        wordDict.add("rs");
        System.out.println(wordBreak("cars", wordDict, memo));

        String[] words = new String[] {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa",
                "aaaaaaaaa","aaaaaaaaaa"};
        wordDict.clear();
        wordDict.addAll(Arrays.asList(words));
        System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                        "aaaaaaaaaaaaab",
                wordDict, memo));
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
}

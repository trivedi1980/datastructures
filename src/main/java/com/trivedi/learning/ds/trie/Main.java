package com.trivedi.learning.ds.trie;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their","abc"};

        String output[] = {"Not present in trie", "Present in trie"};

        Trie t = new Trie();

        System.out.println("Keys to insert: "+ Arrays.toString(keys) + "\n");

        // Construct trie
        int i;
        for (i = 0; i < keys.length ; i++) {
            t.insert(keys[i]);
            System.out.println("\""+ keys[i]+ "\"" + "Inserted.");
        }

        System.out.println(t.search("their"));
        System.out.println(t.search("theirs"));
        System.out.println(t.search("there"));
        System.out.println(t.search("any"));
    }
}

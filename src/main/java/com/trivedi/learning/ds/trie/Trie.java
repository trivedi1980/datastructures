package com.trivedi.learning.ds.trie;

public class Trie {
    private TrieNode root;

    public Trie () {
        this.root = new TrieNode();
    }

    public int getIndex(char c) {
        return c - 'a';
    }

    // Function to insert a key,value pair in the Trie
    public boolean insert(String key) {
        if (key == null || key.isEmpty()) return false;

        key = key.toLowerCase();
        char[] chars = key.toCharArray();
        TrieNode prev = root;
        for (char ch : chars) {
            int index = getIndex(ch);
            TrieNode node = prev.getNode(index);
            if (node == null) {
                node = new TrieNode();
                prev.addNode(index, node);
            }
            prev = node;
        }
        prev.markAsLeaf();
        return true;
    }

    // Function to search given key in Trie
    public boolean search(String key) {
        if (key == null || key.isEmpty()) return false;

        key = key.toLowerCase();
        char[] chars = key.toCharArray();
        TrieNode curr = this.root;
        for (char aChar : chars) {
            int index = getIndex(aChar);
            if (curr.getNode(index) == null) return false;
            curr = curr.getNode(index);
        }
        return curr.isEndWord();
    }

    // Function to delete given key from Trie
    public boolean delete(String key) {
        return false;
    }
}

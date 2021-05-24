package com.trivedi.learning.ds.trie;

public class TrieNode {
    private static final int ALPHABET_SIZE = 26;
    private final TrieNode[] children;
    private boolean endWord;

    public TrieNode() {
        this.children = new TrieNode[ALPHABET_SIZE];
        this.endWord = false;
    }

    public TrieNode(boolean endWord) {
        this.children = new TrieNode[ALPHABET_SIZE];
        this.endWord = endWord;
    }

    public boolean addNode(int index, TrieNode trieNode) {
        if (index < 0 || index >= this.children.length) return false;
        this.children[index] = trieNode;
        return true;
    }

    public TrieNode getNode (int index) {
        if (index < 0 || index >= this.children.length) return null;
        return this.children[index];
    }

    public void markAsLeaf() {
        this.endWord = true;
    }

    public void unMarkAsLeaf() {
        this.endWord = false;
    }

    public boolean isEndWord() {
        return this.endWord;
    }
}

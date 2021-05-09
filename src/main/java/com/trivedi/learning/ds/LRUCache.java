package com.trivedi.learning.ds;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private final Map<String, Entry> entryMap = new HashMap<>();
    private final int size;
    private Entry start;
    private Entry last;
    private int consumedSize;

    public LRUCache(int size) {
        this.size = size;
        this. start = null;
        this.last = null;
        this.consumedSize = 0;
    }

    public synchronized boolean add(String key, String data) {
        if (data.length() > this.size) {
            System.out.println("data size bigger than allocated size..");
            return false;
        }

        if (this.entryMap.containsKey(key)) {
            System.out.println("already exist");
            return false;
        }

        if (this.availableSize() < data.length()) {
            this.allocateSpace(data.length());
        }
        this.insert(key, data);
        return true;
    }

    public String recent() {
        if (this.start != null) {
            return this.start.data;
        }
        return null;
    }

    public String least() {
        if (this.last != null) {
            return this.last.data;
        }
        return null;
    }

    public synchronized String get(String key) {
        if (this.entryMap.containsKey(key)) {
            String data = remove(key);
            insert(key, data);
            return data;
        }
        return null;
    }

    public synchronized String remove(String key) {
        Entry entry = this.entryMap.remove(key);
        if (entry != null) {
            this.consumedSize = this.consumedSize - entry.data.length();
            if (entry == this.start && entry == this.last) {
                this.start = null;
                this.last = null;
            } else if (entry == this.start) {
                this.start = entry.next;
                this.start.prev = null;
            } else if (entry == this.last) {
                this.last = entry.prev;
                this.last.next = null;
            } else {
                entry.prev.next = entry.next;
                entry.next.prev = entry.prev;
            }
            return entry.data;
        }
        return null;
    }

    public int availableSize() {
        return this.size - this.consumedSize;
    }

    public void display() {
        Entry first = this.start;
        System.out.println("Cache allocated size: " + this.size + " and consumed size: " + this.consumedSize);
        while (first != null) {
            System.out.print(first.key + " -> ");
            first = first.next;
        }
        System.out.println("null");
    }

    private void allocateSpace(int length) {
        // remove LRU items from cache
        int reqLength = length - this.availableSize();
        while (reqLength > 0) {
            // need to consider scenario where removeLRUItem() returns 0. goes into infinite loop.
            reqLength = reqLength - removeLRUItem();
        }
    }

    private int removeLRUItem() {
        if (this.last != null) {
            return this.remove(this.last.key).length();
        }
        return 0;
    }

    private void insert(String key, String data) {
        Entry newEntry = createEntry(key, data);
        this.entryMap.put(key, newEntry);
        this.consumedSize += data.length();
        this.addEntryToLinkedList(newEntry);
    }

    private Entry createEntry(String key, String data) {
        Entry entry = new Entry();
        entry.data = data;
        entry.key = key;
        return entry;
    }

    private void addEntryToLinkedList(Entry newEntry) {
        if (this.start == null) {
            this.start = newEntry;
            this.last = newEntry;
            return;
        }

        newEntry.next = this.start;
        this.start.prev = newEntry;
        this.start = newEntry;
    }

    private static class Entry {
        private String data;
        private String key;
        private Entry prev;
        private Entry next;
    }
}



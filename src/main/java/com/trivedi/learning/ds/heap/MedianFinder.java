package com.trivedi.learning.ds.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    //private List<Integer> sortedList = new ArrayList<>();
    public MedianFinder() {

    }

    public void addNum(int num) {
        /*this.sortedList.add(num);
        for (int i = sortedList.size() - 1; i > 0; i--) {
            if (sortedList.get(i) < sortedList.get(i -1)) {
                Collections.swap(sortedList, i, i -1);
            }
        }*/
        if (maxHeap.size() == 0 || maxHeap.peek() < num) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        /*int length = sortedList.size();
        if (length % 2 == 0) {
            return (sortedList.get(length/2) + sortedList.get(length/2 -1))/2.0;
        } else {
            return sortedList.get(length/2);
        }*/
        int length = minHeap.size() + maxHeap.size();
        if (length % 2 == 0) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else if (minHeap.size() > maxHeap.size() ) {
            return minHeap.peek();
        } else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        System.out.println(finder.findMedian());
        finder.addNum(3);
        System.out.println(finder.findMedian());
    }
}

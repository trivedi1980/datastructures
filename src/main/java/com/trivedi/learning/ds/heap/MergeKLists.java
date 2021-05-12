package com.trivedi.learning.ds.heap;

import java.util.PriorityQueue;

public class MergeKLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode one = new ListNode();
        one.val = 1;
        one.next = new ListNode(4);
        ListNode two = new ListNode();
        two.val = 2;
        two.next = new ListNode(5, null);
        ListNode three = new ListNode();
        three.val = 3;

        ListNode[] nodes = new ListNode[3];
        nodes[0] = one;
        nodes[1] = two;
        nodes[2] = three;

        ListNode root = mergeKLists(nodes);
        while(root != null) {
            System.out.print(root.val + " , ");
            root = root.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((n1, n2)-> n1.val - n2.val);
        for (ListNode each : lists) {
            minHeap.offer(each);
        }

        ListNode rootNode = null;
        ListNode curNode = null;
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            if (rootNode == null) {
                rootNode = new ListNode(node.val, null);
                curNode = rootNode;
            } else {
                curNode.next = new ListNode(node.val);
                curNode = curNode.next;
            }

            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }
        return rootNode;
    }
}

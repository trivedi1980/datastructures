package com.trivedi.learning.ds.ls;

public class LinkedListCycleStart {
    private static class ListNode {
        int value = 0;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + findCycleStart(head).value);
    }

    private static ListNode findCycleStart(ListNode root) {
        ListNode cycleNode = hasCycle(root);
        if (cycleNode == null) return null;

        int length = findLength(cycleNode);
        ListNode node1 = root;
        ListNode node2 = root;
        for (int i = 0; i < length; i++) {
            node2 = node2.next;
        }

        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }

    private static int findLength(ListNode root) {
        int count = 1;
        ListNode start = root.next;
        while (start != root) {
            start = start.next;
            count++;
        }
        return count;
    }

    private static ListNode hasCycle(ListNode root) {
        ListNode slow = root;
        ListNode fast = root;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return slow;
        }
        return null;
    }
}

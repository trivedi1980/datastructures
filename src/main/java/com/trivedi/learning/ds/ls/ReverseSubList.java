package com.trivedi.learning.ds.ls;

public class ReverseSubList {
    private static class ListNode {
        int value = 0;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public static ListNode reverse(ListNode head, int p, int q) {
        ListNode pPrev = null;
        ListNode temp = head;
        while (temp != null && temp.value != p) {
            pPrev = temp;
            temp = temp.next;
        }

        ListNode prev = null;
        ListNode curr = temp;
        ListNode next = temp.next;

        while (curr.value != q) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) {
                next = next.next;
            }
        }
        curr.next = prev;
        pPrev.next = curr;
        temp.next = next;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseSubList.reverse(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}

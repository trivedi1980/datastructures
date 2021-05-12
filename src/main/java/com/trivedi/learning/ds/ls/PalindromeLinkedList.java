package com.trivedi.learning.ds.ls;

public class PalindromeLinkedList {
    private static class ListNode {
        int value = 0;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + isPalindrome(head));

        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = reverse(slow);
        ListNode n1 = head;
        ListNode n2 = head2;
        boolean result = true;

        while (n1 != n2) {
            if (n1.value != n2.value) {
                result = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        reverse(head2);

        return result;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode next = head.next;
        while (head != null) {
            head.next = prev;
            prev = head;
            head = next;
            if (next != null)
                next = next.next;
        }
        return prev;
    }
}

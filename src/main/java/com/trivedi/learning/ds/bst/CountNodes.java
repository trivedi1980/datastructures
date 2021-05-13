package com.trivedi.learning.ds.bst;

import java.util.Collections;
import java.util.PriorityQueue;

public class CountNodes {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)),
                new TreeNode(3, new TreeNode(6, null, null), null));
        System.out.println(countNodes(root));
        System.out.println(kthSmallest(root, 3));
    }

    public static int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        traverse(root, k , maxHeap);
        return maxHeap.peek();
    }

    private static void traverse(TreeNode root, int k, PriorityQueue<Integer> maxHeap) {
        if (root == null) return ;
        if (maxHeap.size() >= k) return;

        traverse(root.left, k, maxHeap);
        if (maxHeap.size() < k)
            maxHeap.offer(root.val);
        traverse(root.right, k, maxHeap);
    }

    public static int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = height(root.left, true);
        int rightHeight = height(root.right, false);

        if (leftHeight == rightHeight) return ((int)Math.pow(2, leftHeight + 1) -1);

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static int height(TreeNode head, boolean left) {
        if (head == null) return 0;

        int count = 0;
        while (head != null) {
            head = left ? head.left : head.right;
            count++;
        }

        return count;
    }

}

package com.trivedi.learning.ds.bst;

public class MaxPathSum {
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
        TreeNode root = new TreeNode(-2, null, null);
        root.left = new TreeNode(-1, null, null);
        System.out.println(findMaxPathSum(root));
    }

    private static int findMaxPathSum(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;

        if (root.left == null && root.right == null) return root.val;

        long leftMax = findMaxPathSum(root.left);
        long rightMax = findMaxPathSum(root.right);

        long leftPathMax = Math.max(leftMax, root.val + leftMax);
        long rightPathMax = Math.max(rightMax, root.val + rightMax);

        return (int) Math.max(Math.max(Math.max(root.val, leftMax + rightMax + root.val), leftPathMax), rightPathMax);
    }
}

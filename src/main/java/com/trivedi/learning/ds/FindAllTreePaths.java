package com.trivedi.learning.ds;

import java.util.*;

class FindAllTreePaths {
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        if (root == null) return allPaths;

        List<Integer> currentPath = new ArrayList<>();
        findPaths(root, sum, currentPath, allPaths);

        return allPaths;
    }

    public static void findPaths(TreeNode root, int sum, List<Integer> currentPath, List<List<Integer>> allPaths) {
        currentPath.add(root.val);

        if (root.val == sum && root.left == null && root.right == null) {
            allPaths.add(new ArrayList<>(currentPath));
        }

        if (root.left != null) {
            findPaths(root.left, (sum - root.val), currentPath, allPaths);
        }

        if (root.right != null) {
            findPaths(root.right, (sum - root.val), currentPath, allPaths);
        }
        currentPath.remove(Integer.valueOf(root.val));
    }

    public static int findMaxPathSum(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null && root.right == null) return root.val;

        return Math.max(root.val + findMaxPathSum(root.left), root.val + findMaxPathSum(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);

        System.out.println("Max path sum: " + findMaxPathSum(root));
    }
}


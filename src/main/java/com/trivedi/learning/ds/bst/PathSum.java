package com.trivedi.learning.ds.bst;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        pathSum(root, targetSum, paths, new ArrayList<>());
        return paths;
    }

    private void pathSum(TreeNode root, int targetSum, List<List<Integer>> paths, List<Integer> currentPath) {
        if (root == null) return;

        currentPath.add(root.val);
        if (root.val == targetSum && root.left == null && root.right == null) {
            paths.add(new ArrayList<>(currentPath));
        }

        if (root.left != null) {
            pathSum(root.left, targetSum - root.val, paths, currentPath);
        }

        if (root.right != null) {
            pathSum(root.right, targetSum - root.val, paths, currentPath);
        }
        currentPath.remove(currentPath.size() - 1);
    }

    public static int pathSum2(TreeNode root, int targetSum) {
        if (root == null) return 0;
        return pathSum2(root.left, targetSum) + pathSum2_1(root, targetSum) + pathSum2(root.right, targetSum);
    }

    private static int pathSum2_1(TreeNode root, int targetSum) {
        if (root == null) return 0;

        int result = 0;
        if (root.val == targetSum) result++;
        result += pathSum2(root.left, targetSum - root.val);
        result += pathSum2(root.right, targetSum - root.val);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10, null, null);
        root.left = new TreeNode(5, null, null);
        root.left.left = new TreeNode(3, null, null);
        root.left.left.left = new TreeNode(3, null, null);
        root.left.left.right = new TreeNode(-2, null, null);
        root.left.right = new TreeNode(2, null, null);
        root.left.right.right = new TreeNode(1, null, null);
        root.right = new TreeNode(-3, null, null);
        root.right.right = new TreeNode(11, null, null);
        System.out.println(pathSum2(root, 8));
    }
}

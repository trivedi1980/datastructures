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
}

package org.lqf.learn.leetCode.binaryTree.isSymmetric_101;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

public class Solution01 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(2);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        System.out.println(isSymmetric(root));
    }
    public static boolean isSymmetric(TreeNode root) {
        if(null == root) {
            return true;
        }
        return dfs(root.left,root.right);
    }

    private static boolean dfs(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null) {
            return false;
        }
        if(left.val != right.val) {
            return false;
        }
        return dfs(left.left,right.right) && dfs(left.right,right.left);
    }


}

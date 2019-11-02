package org.lqf.learn.leetCode.binaryTree.maxDepth_104;


import org.lqf.learn.leetCode.binaryTree.TreeNode;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        System.out.println(maxDepth(root));
    }

    private static int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int depLeft = 0;
        int depRight = 0;
        if(null != root.left) {
            depLeft = maxDepth(root.left);
        }
        if(null != root.right) {
            depRight = maxDepth(root.right);
        }
        return depLeft > depRight?depLeft+1:depRight+1;
    }
}

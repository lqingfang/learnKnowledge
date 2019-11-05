package org.lqf.learn.leetCode.binaryTree.maxPathSum_124;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.right = node8;
        System.out.println(maxPathSum(root));
    }

    static int res = Integer.MIN_VALUE;
    private static int maxPathSum(TreeNode root) {
        getPathSum(root);
        return res;
    }

    private static int getPathSum(TreeNode node) {
        if(null == node) {
            return 0;
        }
        int left = getPathSum(node.left);

        int right = getPathSum(node.right);

        res = Math.max(res,left+right+node.val);
        return Math.max(0,Math.max(left,right) +node.val);
    }

}

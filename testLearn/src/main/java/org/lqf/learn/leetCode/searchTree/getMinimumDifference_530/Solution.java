package org.lqf.learn.leetCode.searchTree.getMinimumDifference_530;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(0);
//        TreeNode node6 = new TreeNode(7);
//        TreeNode node7 = new TreeNode(2);
//        TreeNode node8 = new TreeNode(1);
        //root.left = node1;
//        root.left = node3;
//        node3.left = node4;
        //node4.left = node5;
        root.right = node1;
//        node1.left = node2;
//        node1.left = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node3.left = node6;
//        node3.right = node7;
//        node5.right = node8;

        System.out.println(getMinimumDifference(root));
    }

    static int min = Integer.MAX_VALUE;
    static TreeNode pre;
    private static int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return min;
    }

    private static void inOrder(TreeNode root) {
        if(null == root) {
            return;
        }
        inOrder(root.left);
        if(pre != null) {
            min = Math.min(min, root.val - pre.val);
        }
        pre = root;
        inOrder(root.right);
    }
}

package org.lqf.learn.leetCode.searchTree.deleteNode_450;

import org.lqf.learn.leetCode.searchTree.TreeNode;

public class Solution01 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(15);
        TreeNode node6 = new TreeNode(14);
        TreeNode node7 = new TreeNode(17);
        //root.left = node2;
        root.right = node5;
//        node2.left = node1;
//        node2.right = node3;
//        node5.left = node6;
//        node5.right = node7;

        int val = 15;
        System.out.println(deleteNode(root, val));
    }
    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return root;
        }
        if(root.val < key) {
            root.right = deleteNode(root.right,key);
            return root;
        }
        if(root.val > key) {
            root.left = deleteNode(root.left,key);
            return root;
        }
        //下面处理相等的情况
        if(root.left == null) {
            return root.right;
        }
        if(root.right == null) {
            return root.left;
        }
        //下面处理左右都不为空

        int val = findMaxNode(root.left);
        TreeNode newNode = new TreeNode(val);
        newNode.left = reLeftRemoveMax(root.left);
        newNode.right = root.right;
        return newNode;
    }
    private static TreeNode reLeftRemoveMax(TreeNode node) {
        if (null == node) {
            return null;
        }
        if (null == node.right) {
            TreeNode left = node.left;
            node.left = null;
            return left;
        }
        node.right = reLeftRemoveMax(node.right);
        return node;
    }

    private static int findMaxNode(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.val;
    }
}

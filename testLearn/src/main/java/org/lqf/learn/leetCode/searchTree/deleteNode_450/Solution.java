package org.lqf.learn.leetCode.searchTree.deleteNode_450;

import org.lqf.learn.leetCode.searchTree.TreeNode;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(15);
        TreeNode node6 = new TreeNode(14);
        TreeNode node7 = new TreeNode(17);
        root.left = node2;
        root.right = node5;
        node2.left = node1;
        node2.right = node3;
        node5.left = node6;
        node5.right = node7;

        int val = 15;
        System.out.println(deleteNode(root, val));
    }

    private static TreeNode deleteNode(TreeNode root, int val) {
        if (null == root) {
            return null;
        }
        if (val < root.val) {
            root.left = deleteNode(root.left, val);
            return root;
        }
        if (val > root.val) {
            root.right = deleteNode(root.right, val);
            return root;
        }

        if (null == root.left) {
            TreeNode right = root.right;
            root.right = null;
            return right;
        }
        if (null == root.right) {
            TreeNode left = root.left;
            root.left = null;
            return left;
        }
        TreeNode node = getMaxTreeNode(root.left);
        TreeNode newRoot = new TreeNode(node.val);
        newRoot.left = reLeftRemoveMax(root.left);
        newRoot.right = root.right;
        root.right = null;
        root.left = null;
        return newRoot;

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

    private static TreeNode getMaxTreeNode(TreeNode node) {
        if (null == node.right) {
            return node;
        }
        return getMaxTreeNode(node.right);
    }
}

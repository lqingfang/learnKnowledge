package org.lqf.learn.leetCode.binaryTree.pruneTree_814;

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
        TreeNode treeNode = pruneTree(root);
        System.out.println(treeNode.val);
    }

    private static TreeNode pruneTree(TreeNode root) {
        if(null == root) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right =pruneTree(root.right);
        if(root.val ==0 && null==root.left && null==root.right) {
            return null;
        }
        return root;
    }
}

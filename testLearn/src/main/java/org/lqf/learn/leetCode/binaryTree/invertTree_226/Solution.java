package org.lqf.learn.leetCode.binaryTree.invertTree_226;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

import java.util.List;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        //TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
//        TreeNode node3 = new TreeNode(11);
//        TreeNode node4 = new TreeNode(13);
//        TreeNode node5 = new TreeNode(4);
//        TreeNode node6 = new TreeNode(7);
//        TreeNode node7 = new TreeNode(2);
//        TreeNode node8 = new TreeNode(1);
        //root.left = node1;
        root.right = node2;
//        node1.left = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node3.left = node6;
//        node3.right = node7;
//        node5.right = node8;
        invertTree(root);
    }

    private static TreeNode invertTree(TreeNode root) {
        if(null == root || (null == root.left && null == root.right)) {
            return root;
        }

        if(null != root.left && null != root.right) {
            TreeNode temp = root.left;
            invertTree(root.right);
            root.left = root.right;
            invertTree(temp);
            root.right = temp;
        }
        if(null == root.left) {
            invertTree(root.right);
            root.left = root.right;
            root.right = null;
        } else if(null == root.right) {
            invertTree(root.left);
            root.right = root.left;
            root.left = null;
        }
        return root;
    }
}

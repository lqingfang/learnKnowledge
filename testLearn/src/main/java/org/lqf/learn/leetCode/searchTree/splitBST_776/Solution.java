package org.lqf.learn.leetCode.searchTree.splitBST_776;


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

        int val = 4;
        splitBST(root,val);
    }

    private static TreeNode[] splitBST(TreeNode root, int val) {
        if(null == root) {
            return new TreeNode[2];
        }
        TreeNode[] treeNodes = new TreeNode[2];
        if(val >= root.val) {
            treeNodes[0] = root;
            TreeNode[] rightTreeNodes = splitBST(root.right,val);
            root.right = rightTreeNodes[0];
            treeNodes[1] = rightTreeNodes[1];
        }else {
            treeNodes[1] = root;
            TreeNode[] leftTreeNodes = splitBST(root.left,val);
            treeNodes[0] = leftTreeNodes[0];
            root.left = leftTreeNodes[1];
        }
        return treeNodes;
    }

}

package org.lqf.learn.leetCode.searchTree.convertBST_538;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

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
        System.out.println(convertBST(root));
    }

    static int sum = 0;
    private static TreeNode convertBST(TreeNode root) {
        if(null != root) {
            convertBST(root.right);
            sum +=root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}

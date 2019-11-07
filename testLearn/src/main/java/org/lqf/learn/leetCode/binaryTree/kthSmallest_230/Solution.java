package org.lqf.learn.leetCode.binaryTree.kthSmallest_230;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);
        root.left = node1;
        root.right = node2;
        node1.right = node4;
        int k = 3;
        System.out.println(kthSmallest(root,k));
    }

    static int value = -1;
    static int index = 0;
    private static int kthSmallest(TreeNode root, int k) {
        getKValue(root,k);
        return value;
    }

    private static void getKValue(TreeNode root, int k) {
        if(null == root) {
            return;
        }
        getKValue(root.left,k);
        if(++index == k) {
            value = root.val;
            return;
        }
        getKValue(root.right,k);
    }
}

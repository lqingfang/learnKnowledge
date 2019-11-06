package org.lqf.learn.leetCode.binaryTree.isSameTree_100;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

public class Solution {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        p.left = node1;
        p.right = node2;
        node2.left = node3;
        node2.right = node4;

        TreeNode q = new TreeNode(20);
        TreeNode node5 = new TreeNode(10);
        TreeNode node6 = new TreeNode(22);
        TreeNode node7 = new TreeNode(9);
        TreeNode node8 = new TreeNode(3);
        q.left = node5;
        q.right = node6;
        node5.left = node7;
        node5.right = node8;

        System.out.println(isSameTree(p,q));
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        if(p.val == q.val) {
            if(isSameTree(p.left,q.left) && isSameTree(p.right,q.right)) {
                return true;
            }
        }
        return false;
    }

}

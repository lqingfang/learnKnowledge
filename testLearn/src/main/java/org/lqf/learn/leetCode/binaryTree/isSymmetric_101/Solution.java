package org.lqf.learn.leetCode.binaryTree.isSymmetric_101;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        System.out.println(isSymmetric(root));
    }

    private static boolean isSymmetric(TreeNode root) {
        if(null == root) {
            return true;
        }
        return isMirror(root,root);
    }

    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        if(null == t1 && null == t2) {
            return true;
        }
        if(null == t1 || null == t2) {
            return false;
        }
        return t1.val == t2.val && isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left);
    }
}

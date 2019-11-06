package org.lqf.learn.leetCode.binaryTree.mergeTrees_617;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

public class Solution {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        t1.left = node1;
        t1.right = node2;
        node2.left = node3;
        node2.right = node4;

        TreeNode t2 = new TreeNode(4);
        TreeNode node5 = new TreeNode(10);
        TreeNode node6 = new TreeNode(22);
        TreeNode node7 = new TreeNode(9);
        TreeNode node8 = new TreeNode(3);
        t2.left = node5;
        t2.right = node6;
        node5.left = node7;
        node5.right = node8;

        mergeTrees(t1,t2);
    }

    private static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(null == t1 && null == t2) {
            return t1;
        }
        if(null == t1 && null != t2) {
            return t2;
        }
        if(null != t1 && null == t2) {
            return t1;
        }
        TreeNode node = new TreeNode(t1.val+t2.val);
        node.left = mergeTrees(t1.left,t2.left);
        node.right = mergeTrees(t1.right,t2.right);
        return node;
    }
}

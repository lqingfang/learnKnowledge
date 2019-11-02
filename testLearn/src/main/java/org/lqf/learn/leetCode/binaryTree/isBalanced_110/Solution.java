package org.lqf.learn.leetCode.binaryTree.isBalanced_110;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
//        TreeNode node2 = new TreeNode(20);
//        TreeNode node3 = new TreeNode(15);
//        TreeNode node4 = new TreeNode(7);
        root.left = node1;
//        root.right = node2;
//        node2.left = node3;
//        node2.right = node4;
        System.out.println(isBalanced(root));
    }

    private static boolean isBalanced(TreeNode root) {
        if(null == root || (null == root.left && null == root.right)) {
            return true;
        }
        boolean leftBalance = false;
        if(null != root.left) {
            leftBalance= isBalanced(root.left);
        }else {
            leftBalance = true;
        }

        boolean rightBalance = false;
        if(null != root.right) {
            rightBalance = isBalanced(root.right);
        }else {
            rightBalance = true;
        }

        if(leftBalance && rightBalance) {
            int leftDep = getDeep(root.left);
            int rightDep = getDeep(root.right);
            if(Math.abs(leftDep-rightDep) >1) {
                return false;
            }else {
                return true;
            }
        }else {
            return false;
        }
    }

    private static int getDeep(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int leftDep = 0;
        if(null != node.left) {
            leftDep = getDeep(node.left);
        }
        int rightDep = 0;
        if(null != node.right) {
            rightDep = getDeep(node.right);
        }
        return leftDep>rightDep?leftDep+1:rightDep+1;
    }
}

package org.lqf.learn.leetCode.binaryTree.minDepth_111;


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
        System.out.println(minDepth(root));
    }

    private static int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int depLeft = 0;
        int depRight = 0;
        if(null != root.left) {
            depLeft = minDepth(root.left);
        }
        if(null != root.right) {
            depRight = minDepth(root.right);
        }
        int minDeep;
        if(depLeft <= depRight) {
            minDeep = depLeft+1;
        }else {
            minDeep = depRight+1;
        }

        if(minDeep == 1 && ((depLeft>0 && depRight==0)||(depLeft==0 && depRight>0))) {
            minDeep = depLeft==0?depRight+1:depLeft+1;
        }
        return minDeep;

    }
}

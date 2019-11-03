package org.lqf.learn.leetCode.binaryTree.hasPathSum_112;

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
        int sum = 22;
        System.out.println(hasPathSum(root,sum));
    }

    private static boolean hasPathSum(TreeNode root, int sum) {
        if(null == root){
            return false;
        }
        if(root.val == sum && null == root.left && null == root.right) {
            return true;
        }
        sum = sum - root.val;
        boolean leftHasPathSum = false;
        if(null != root.left) {
            leftHasPathSum = hasPathSum(root.left,sum);
        }

        boolean rightHasPathSum = false;
        if(null != root.right) {
            rightHasPathSum = hasPathSum(root.right,sum);
        }
        if(leftHasPathSum || rightHasPathSum) {
            return true;
        }
        return false;
    }


}

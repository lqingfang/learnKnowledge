package org.lqf.learn.leetCode.binaryTree.longestUnivaluePath_687;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node3.left = node5;
        node2.left = node6;
        node6.left = node7;
        System.out.println(longestUnivaluePath(root));
    }

    static int ans;
    private static int longestUnivaluePath(TreeNode root) {
        ans = 0;
        arrowLength(root);
        return ans;
    }
    public static int arrowLength(TreeNode node) {
       if(null == node) {
           return 0;
       }
       int left = arrowLength(node.left);
       int right = arrowLength(node.right);

       //leftLength 记录的是 和当前跟节点相同时的，长度
       int leftLength = 0;
       if(null != node.left && node.val == node.left.val) {
           leftLength = left+1;
       }
       int rightLength = 0;
       if(null != node.right && node.val == node.right.val) {
           rightLength = right+1;
       }
       //ans记录的是当前最大
       ans = Math.max(ans,leftLength+rightLength);
       return Math.max(leftLength,rightLength);
    }
}

package org.lqf.learn.leetCode.binaryTree.lowestCommonAncestor_235;

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
        TreeNode treeNode = lowestCommonAncestor(root,node3,node5);
        System.out.println(treeNode.val);
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(null == root || null == p || null == q) {
            return root;
        }

        if(null != root.left && root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left,p,q);
        }

        if(null != root.right && root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right,p,q);
        }

        return root;
    }
}

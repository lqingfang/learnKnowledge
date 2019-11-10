package org.lqf.learn.leetCode.searchTree.insertIntoBST_701;

import org.lqf.learn.leetCode.searchTree.TreeNode;

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

//        TreeNode root = new TreeNode(10);
//        TreeNode node1 = new TreeNode(10);
//        root.left = node1;
        int val = 16;
        System.out.println(insertIntoBST(root,val));
    }

    private static TreeNode insertIntoBST(TreeNode root, int val) {
        if(null == root) {
            return new TreeNode(val);
        }
        if(root.val > val) {
            if(null == root.left) {
                root.left = new TreeNode(val);
                return root;
            }else {
                insertIntoBST(root.left,val);
            }
        }
        if(root.val < val) {
            if(null == root.right) {
                root.right = new TreeNode(val);
                return root;
            }else {
                insertIntoBST(root.right,val);
            }
        }
        return root;
    }
}

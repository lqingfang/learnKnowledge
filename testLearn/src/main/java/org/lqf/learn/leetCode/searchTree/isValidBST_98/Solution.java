package org.lqf.learn.leetCode.searchTree.isValidBST_98;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

import java.util.Arrays;

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
        System.out.println(isValidBST(root));
    }

    static double last = -Double.MAX_VALUE;
    private static boolean isValidBST(TreeNode root) {
        if(null == root) {
            return true;
        }
        if(isValidBST(root.left)) {
            if(last <root.val) {
                last = root.val;
                return isValidBST(root.right);
            }
        }
        return false;
    }

}

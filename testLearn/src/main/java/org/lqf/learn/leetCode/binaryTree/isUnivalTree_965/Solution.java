package org.lqf.learn.leetCode.binaryTree.isUnivalTree_965;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        System.out.println(isUnivalTree(root));
    }

    private static boolean isUnivalTree(TreeNode root) {
        if(null == root) {
            return true;
        }
        int value = root.val;
        if(isOneValue(root.left,value) && isOneValue(root.right,value)) {
            return true;
        }
        return false;
    }

    private static boolean isOneValue(TreeNode node, int value) {
        if(null == node) {
            return true;
        }
        if(value != node.val) {
            return false;
        }
        if(isOneValue(node.left,value) && (isOneValue(node.right,value))) {
            return true;
        }
        return false;
    }
}

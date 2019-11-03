package org.lqf.learn.leetCode.binaryTree.diameterOfBinaryTree_543;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(4);
//        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        //root.right = node2;
        node1.right = node2;
//        node2.left = node3;
//        node2.right = node4;
        System.out.println(diameterOfBinaryTree(root));
    }

    static int max = 0;
    private static int diameterOfBinaryTree(TreeNode root) {
        dep(root);
        return max;
    }

    private static int dep(TreeNode node) {
        if(null == node) {
            return 0;
        }
        int leftLen = dep(node.left);

        int rightLen = dep(node.right);

        max = Math.max((leftLen+rightLen),max);
        return leftLen>rightLen?leftLen+1:rightLen+1;
    }
}

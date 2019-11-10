package org.lqf.learn.leetCode.searchTree.convertBST_538;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

import java.util.Stack;

public class Solution02 {
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
        System.out.println(convertBST(root));
    }


    private static TreeNode convertBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        int sum = 0;
        while (!stack.isEmpty() || null != node) {
            while (null != node) {
                stack.push(node);
                node = node.right;
            }
            node = stack.pop();
            sum += node.val;
            node.val = sum;

            node = node.left;
        }
        return root;
    }
}

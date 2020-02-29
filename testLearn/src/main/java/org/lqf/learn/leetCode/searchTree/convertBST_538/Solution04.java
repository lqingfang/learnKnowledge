package org.lqf.learn.leetCode.searchTree.convertBST_538;

import org.lqf.learn.leetCode.searchTree.TreeNode;

import java.util.Stack;

/**
 * stack
 */
public class Solution04 {
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
    static Stack<TreeNode> stack;
    public static TreeNode convertBST(TreeNode root) {
        stack = new Stack<>();
        dfs(root);
        int sum = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            node.val = node.val+sum;
            sum = node.val;
        }
        return root;
    }
    public static void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        dfs(root.left);
        stack.push(root);
        dfs(root.right);
    }
}


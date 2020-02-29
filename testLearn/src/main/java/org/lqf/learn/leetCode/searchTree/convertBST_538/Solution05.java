package org.lqf.learn.leetCode.searchTree.convertBST_538;

import org.lqf.learn.leetCode.searchTree.TreeNode;

import java.util.Stack;

public class Solution05 {
    public static void main(String[] args) {

    }
    public TreeNode convertBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        int sum = 0;
        while (!stack.isEmpty() || null!= node) {
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

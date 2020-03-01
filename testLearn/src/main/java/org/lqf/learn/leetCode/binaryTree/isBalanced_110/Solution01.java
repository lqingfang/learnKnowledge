package org.lqf.learn.leetCode.binaryTree.isBalanced_110;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

public class Solution01 {
    public static void main(String[] args) {

    }
    public boolean isBalanced(TreeNode root) {
        if(null == root) {
            return true;
        }
        int leftDeep = 0;
        int rightDeep = 0;
        if(root.left != null) {
            if(isBalanced(root.left)) {
                leftDeep = dfs(root.left);
            } else {
                return false;
            }
        }
        if(root.right != null) {
            if(isBalanced(root.right)) {
                rightDeep = dfs(root.right);
            } else {
                return false;
            }
        }
        return Math.abs(leftDeep-rightDeep)<2;
    }

    private int dfs(TreeNode node) {
        if(null == node) {
            return 0;
        }
        int leftDeep = 0;
        int rightDeep = 0;
        if(node.left != null) {
            leftDeep = dfs(node.left);
        }
        if(node.right != null) {
            rightDeep = dfs(node.right);
        }
        return leftDeep > rightDeep?leftDeep+1:rightDeep+1;
    }
}

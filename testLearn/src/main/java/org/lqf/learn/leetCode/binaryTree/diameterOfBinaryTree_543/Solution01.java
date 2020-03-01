package org.lqf.learn.leetCode.binaryTree.diameterOfBinaryTree_543;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

public class Solution01 {
    public static void main(String[] args) {

    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(null == root) {
            return 0;
        }
        int leftDeep = 0;
        int rightDeep = 0;
        int leftDiameter = 0;
        int rightDiameter = 0;
        if(root.left != null) {
            leftDiameter = diameterOfBinaryTree(root.left);
            leftDeep = dfs(root.left);
        }
        if(root.right != null) {
            rightDiameter = diameterOfBinaryTree(root.right);
            rightDeep = dfs(root.right);
        }
        int max = Integer.MIN_VALUE;
        max = Math.max(leftDiameter,rightDiameter);
        max = Math.max(max,leftDeep+rightDeep);
        return max;
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
        return leftDeep>rightDeep?leftDeep+1:rightDeep+1;
    }
}

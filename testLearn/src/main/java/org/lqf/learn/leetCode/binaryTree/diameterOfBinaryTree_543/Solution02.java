package org.lqf.learn.leetCode.binaryTree.diameterOfBinaryTree_543;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

public class Solution02 {
    public static void main(String[] args) {

    }
    static int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        dfs(root);
        return max;
    }
    public static int dfs(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int leftDeep = dfs(node.left);;
        int rightDeep = dfs(node.right);
        max = Math.max((leftDeep+rightDeep),max);
        return leftDeep>rightDeep?leftDeep+1:rightDeep+1;
    }
}

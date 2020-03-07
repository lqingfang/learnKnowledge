package org.lqf.learn.leetCode.binaryTree.invertTree_226;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

/**
 * dfs
 */
public class Solution01 {
    public static void main(String[] args) {

    }
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }
    public void dfs(TreeNode node) {
        if(node == null) {
            return;
        }
        TreeNode tempNode = node.left;
        node.left = node.right;
        node.right = tempNode;
        dfs(node.left);
        dfs(node.right);
    }
}

package org.lqf.learn.leetCode.binaryTree.isUnivalTree_965;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

public class Solution01 {
    public static void main(String[] args) {

    }
    public boolean isUnivalTree(TreeNode root) {
        if(null == root) {
            return true;
        }
        int value = root.val;
        return dfs(root,value);
    }

    private boolean dfs(TreeNode root,int value) {
        if(root == null) {
            return true;
        }
        if(root.val != value) {
            return false;
        }
        return dfs(root.left,value) && dfs(root.right,value);
    }
}

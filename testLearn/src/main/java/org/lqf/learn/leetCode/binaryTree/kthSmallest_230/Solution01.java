package org.lqf.learn.leetCode.binaryTree.kthSmallest_230;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

/**
 * dfs
 */
public class Solution01 {
    public static void main(String[] args) {

    }
    int index;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        index = 0;
        dfs(root,k);
        return res;
    }
    public void dfs(TreeNode node,int k) {
        if(null == node) {
            return ;
        }
        dfs(node.left,k);
        if(++index == k) {
            res = node.val;
            return;
        }
        dfs(node.right,k);
    }
}

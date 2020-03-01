package org.lqf.learn.leetCode.binaryTree.maxDepth_104;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

/**
 * dfs
 */
public class Solution01 {
    public static void main(String[] args) {

    }
    public int maxDepth(TreeNode root) {
        if(null == root) {
            return 0;
        }
        int leftDeep = 0;
        int rightDeep = 0;
        if(null != root.left) {
            leftDeep = maxDepth(root.left);
        }
        if(null != root.right) {
            rightDeep = maxDepth(root.right);
        }
        return leftDeep > rightDeep?leftDeep+1:rightDeep+1;
    }
}

package org.lqf.learn.leetCode.binaryTree.minDepth_111;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

/**
 * dfs
 */
public class Solution01 {
    public static void main(String[] args) {

    }
    public int minDepth(TreeNode root) {
        if(null == root) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        int minDeep = Integer.MAX_VALUE;
        if(root.left != null) {
            minDeep = Math.min(minDeep,minDepth(root.left));
        }
        if(root.right != null) {
            minDeep = Math.min(minDeep,minDepth(root.right));
        }
        return minDeep+1;
    }
}

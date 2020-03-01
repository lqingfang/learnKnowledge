package org.lqf.learn.leetCode.binaryTree.hasPathSum_112;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

/**
 * dfs
 */
public class Solution02 {
    public static void main(String[] args) {

    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        if(root.val == sum && root.left == null && root.right == null) {
            return true;
        }
        if(root.left != null) {
            if(hasPathSum(root.left,sum-root.val)) {
                return true;
            }
        }
        if(root.right != null) {
            if(hasPathSum(root.right,sum-root.val)) {
                return true;
            }
        }
        return false;
    }
}

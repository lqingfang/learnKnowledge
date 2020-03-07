package org.lqf.learn.leetCode.binaryTree.isSameTree_100;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

/**
 * dfs
 */
public class Solution01 {
    public static void main(String[] args) {

    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        if(p.val != q.val) {
            return false;
        }
        if(isSameTree(p.left,q.left) && isSameTree(p.right,q.right)) {
            return true;
        }
        return false;
    }
}

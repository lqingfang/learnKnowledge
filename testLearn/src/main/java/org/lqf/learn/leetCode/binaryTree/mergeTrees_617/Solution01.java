package org.lqf.learn.leetCode.binaryTree.mergeTrees_617;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

/**
 * dfs
 */
public class Solution01 {
    public static void main(String[] args) {

    }
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return null;
        }
        if(t1 == null && t2 != null) {
            return t2;
        }
        if(t1 != null && t2 == null) {
            return t1;
        }
        TreeNode root = new TreeNode(t1.val+t2.val);
        root.left = mergeTrees(t1.left,t2.left);
        root.right = mergeTrees(t1.right,t2.right);
        return root;
    }
}

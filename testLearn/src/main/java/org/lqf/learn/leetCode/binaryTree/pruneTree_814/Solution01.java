package org.lqf.learn.leetCode.binaryTree.pruneTree_814;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

public class Solution01 {
    public TreeNode pruneTree(TreeNode root) {
        if(null == root) {
            return root;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.val == 0 && null == root.left && null == root.right) {
            return null;
        }
        return root;
    }
}

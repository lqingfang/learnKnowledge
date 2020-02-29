package org.lqf.learn.leetCode.searchTree.insertIntoBST_701;

import org.lqf.learn.leetCode.searchTree.TreeNode;

public class Solution01 {
    public static void main(String[] args) {

    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if(root == null) {
            return node;
        }
        if(root.val < val) {
            if(null == root.right) {
                root.right = node;
                return root;
            }
            insertIntoBST(root.right,val);
        }else {
            if(null == root.left) {
                root.left = node;
                return root;
            }
            insertIntoBST(root.left,val);
        }
        return root;
    }
}

package org.lqf.learn.leetCode.binaryTree.lowestCommonAncestor_235;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

public class Solution01 {
    public static void main(String[] args) {

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(null == root || root.val == p.val || root.val == q.val) {
            return root;
        }
        if(root.left != null && p.val<root.val && q.val <root.val) {
            return lowestCommonAncestor(root.left,p,q);
        }
        if(root.right != null && p.val>root.val && q.val >root.val) {
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
}

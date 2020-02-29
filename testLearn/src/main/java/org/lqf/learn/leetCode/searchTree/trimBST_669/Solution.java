package org.lqf.learn.leetCode.searchTree.trimBST_669;

import org.lqf.learn.leetCode.searchTree.TreeNode;

public class Solution {
    public static void main(String[] args) {

    }
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(null == root) {
            return null;
        }
        if(root.val > R) {
            return trimBST(root.left,L,R);
        }
        if(root.val < L) {
            return trimBST(root.right,L,R);
        }
        root.left = trimBST(root.left,L,R);
        root.right = trimBST(root.right,L,R);
        return root;
    }
}

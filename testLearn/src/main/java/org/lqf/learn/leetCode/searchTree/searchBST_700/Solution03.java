package org.lqf.learn.leetCode.searchTree.searchBST_700;

import org.lqf.learn.leetCode.searchTree.TreeNode;

public class Solution03 {
    public static void main(String[] args) {

    }
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) {
            return null;
        }
        if(root.val == val) {
            return root;
        }
        if(root.val > val) {
            return searchBST(root.left,val);
        }else {
            return searchBST(root.right,val);
        }
    }
}

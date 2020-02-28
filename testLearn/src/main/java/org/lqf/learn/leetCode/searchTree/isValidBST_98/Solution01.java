package org.lqf.learn.leetCode.searchTree.isValidBST_98;

import org.lqf.learn.leetCode.searchTree.TreeNode;

/**
 * dfs
 */
public class Solution01 {
    public static void main(String[] args) {

    }
    public boolean isValidBST(TreeNode root) {
        return dfs(root,null,null);
    }

    private boolean dfs(TreeNode root, Integer low, Integer high) {
        if(null == root) {
            return true;
        }
        int val = root.val;
        if(low != null && val <= low) {
            return false;
        }
        if(!dfs(root.left,low,val)){
            return false;
        }
        if(high != null && high <= val ){
            return false;
        }
        if(!dfs(root.right,val,high)) {
            return false;
        }
        return true;
    }
}

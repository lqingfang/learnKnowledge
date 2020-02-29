package org.lqf.learn.leetCode.searchTree.convertBST_538;

import org.lqf.learn.leetCode.searchTree.TreeNode;

/**
 * dfs
 */
public class Solution03 {
    public static void main(String[] args) {

    }
    static int preSum = 0;
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }
    public void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        dfs(root.right);
        root.val = root.val+preSum;
        preSum = root.val;
        dfs(root.left);
    }
}

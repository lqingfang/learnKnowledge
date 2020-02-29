package org.lqf.learn.leetCode.searchTree.getMinimumDifference_530;

import org.lqf.learn.leetCode.searchTree.TreeNode;
/**
 * dfs 不存储
 */
public class Solution02 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        root.right = node1;
        node1.left = node2;
        System.out.println(getMinimumDifference(root));
    }
    static int min = Integer.MAX_VALUE;
    static TreeNode pre = null;
    public static int getMinimumDifference(TreeNode root) {
        dfs(root);
        return min;
    }

    private static void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        dfs(root.left);
        if(pre != null){
            min = Math.min(min,root.val - pre.val);
        }
        pre = root;
        dfs(root.right);
    }
}

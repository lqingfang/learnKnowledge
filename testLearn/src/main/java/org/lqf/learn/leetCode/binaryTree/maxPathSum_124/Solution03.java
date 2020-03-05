package org.lqf.learn.leetCode.binaryTree.maxPathSum_124;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

/**
 * dfs
 */
public class Solution03 {
    public static void main(String[] args) {

    }
    static int res;
    public int maxPathSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        res = Integer.MIN_VALUE;
        dfs(root);
        return res;
    }
    public int dfs(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int left = dfs(node.left);

        int right = dfs(node.right);

        //res 是用来记录最大值的，可以左右选，再加上根节点
        res = Math.max(res,left+right+node.val);
        //左右最大的值，连接上根节点，考虑到负数
        return Math.max(0,Math.max(left,right)+node.val);
    }
}

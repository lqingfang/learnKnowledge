package org.lqf.learn.leetCode.binaryTree.longestUnivaluePath_687;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

public class Solution01 {
    public static void main(String[] args) {

    }
    static int ans;
    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        if(root == null) {
            return ans;
        }
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode node) {
        if(null == node) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);

        //leftLength 记录的是 和当前跟节点相同时的，长度
        //如果不相等，则为0
        int leftLength = 0;
        if(node.left != null && node.left.val == node.val) {
            leftLength = left+1;
        }
        int rightLength = 0;
        if(node.right != null && node.right.val == node.val) {
            rightLength = right+1;
        }
        //ans记录的是当前最大
        ans = Math.max(ans,leftLength+rightLength);
        //只能够使用单边
        return Math.max(leftLength,rightLength);
    }
}

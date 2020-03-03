package org.lqf.learn.leetCode.binaryTree.pathSum_437;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution02 {
    public static void main(String[] args) {

    }
    public int pathSum(TreeNode root, int sum) {
        if(null == root) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int curSum = 0;
            res += dfs(node,sum,curSum);
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
        return res;
    }
    public int dfs(TreeNode node,int sum,int curSum) {
        int ans = 0;
        curSum += node.val;
        if (curSum == sum) {
            ++ans;
        }
        if (node.left != null) {
            ans += dfs(node.left, sum, curSum);
        }
        if (node.right != null) {
            ans += dfs(node.right, sum, curSum);
        }
        return ans;
    }
}

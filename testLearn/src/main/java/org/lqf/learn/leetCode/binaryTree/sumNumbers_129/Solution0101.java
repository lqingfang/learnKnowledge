package org.lqf.learn.leetCode.binaryTree.sumNumbers_129;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * dfs
 */
public class Solution0101 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        System.out.println(sumNumbers(root));
    }
    public static int sumNumbers(TreeNode root) {
        if(null == root) {
            return 0;
        }
        return dfs(root,0);
    }
    public static int dfs(TreeNode node, int tmpsum) {
        if(node.left == null && node.right == null) {
            return tmpsum*10+node.val;
        }
        int sum = 0;
        if(node.left != null) {
            sum =  dfs(node.left,tmpsum*10+node.val);
        }
        if(node.right != null) {
            sum += dfs(node.right,tmpsum*10+node.val);
        }
        return sum;
    }
}

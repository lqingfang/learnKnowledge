package org.lqf.learn.leetCode.binaryTree.pathSum_437;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

/**
 * dfs
 */
public class Solution01 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(1);
        TreeNode node9 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node9;
        node5.right = node8;
        int sum = 22;
        System.out.println(pathSum(root,sum));
    }

    public static int pathSum(TreeNode root, int sum) {
        if(null == root) {
            return 0;
        }
        return dfs(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
    }
    public static int dfs(TreeNode node,int sum) {
        if(null == node) {
            return 0;
        }
        sum -= node.val;

        return (sum==0?1:0)+dfs(node.left,sum) +dfs(node.right,sum);
    }
}

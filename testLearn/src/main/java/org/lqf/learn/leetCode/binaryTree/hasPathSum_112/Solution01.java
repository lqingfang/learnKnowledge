package org.lqf.learn.leetCode.binaryTree.hasPathSum_112;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * bfs
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
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.right = node8;
        int sum = 22;
        System.out.println(hasPathSum(root,sum));
    }
    public static boolean hasPathSum(TreeNode root, int sum) {
        if(null == root && sum>0) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Queue<Integer> queueSum = new LinkedList<>();
        queueSum.add(root.val);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                Integer sumCur = queueSum.poll();
                if(node.left == null && node.right == null && sumCur == sum) {
                    return true;
                }
                if(node.left != null) {
                    queue.add(node.left);
                    queueSum.add(node.left.val + sumCur);
                }
                if(node.right != null) {
                    queue.add(node.right);
                    queueSum.add(node.right.val + sumCur);
                }
            }
        }
        return false;
    }
}
